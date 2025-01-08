package com.bestbuy.cucumber.steps;

import com.bestbuy.bestbuyinfo.StoreCURDSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;

public class StoreSteps {

    ValidatableResponse response;

    @Steps
    StoreCURDSteps storeCURDSteps;
    static int storeId;

    @When("I create a new store using name {string} type {string} address {string} address {string} city {string} state {string} zip {string}")
    public void iCreateANewStoreUsingNameTypeAddressAddressCityStateZip(String name, String type, String address, String address2, String city, String state, String zip) {
        storeCURDSteps.createRecordForStore(name, type, address, address2, city, state, zip);
    }

    @Then("I delete the store that created with id")
    public void iDeleteTheStoreThatCreatedWithId() {
        storeCURDSteps.deleteRecord(storeId);
        System.out.println(storeId);
    }

    @Then("The store deleted successfully from the application")
    public void theStoreDeletedSuccessfullyFromTheApplication() {
        response.statusCode(204);
    }
}
