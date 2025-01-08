package com.bestbuy.cucumber.steps;

import com.bestbuy.bestbuyinfo.StoreCURDSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;

public class StoreSteps {

    ValidatableResponse response;
    static int storeId;

    @Steps
    StoreCURDSteps storeCURDSteps;

    @When("I create a new store using name {string} type {string} address {string} address {string} city {string} state {string} zip {string}")
    public void iCreateANewStoreUsingNameTypeAddressAddressCityStateZip(String name, String type, String address, String address2, String city, String state, String zip) {
        response = storeCURDSteps.createRecordForStore(name, type, address, address2, city, state, zip);
        storeId = response.extract().path("id");
        System.out.println(storeId);
    }

    @Then("I delete the store that created with id")
    public void iDeleteTheStoreThatCreatedWithId() {
        System.out.println("-------" + storeId);
        storeCURDSteps.deleteRecord(storeId);

    }

    @Then("The store deleted successfully from the application")
    public void theStoreDeletedSuccessfullyFromTheApplication() {
        response.statusCode(201);
    }

    @And("I update a new store using name {string} type {string} address {string} address {string} city {string} state {string} zip {string}")
    public void iUpdateANewStoreUsingNameTypeAddressAddressCityStateZip(int id,String name, String type, String address, String address2, String city, String state, String zip) {
        response = storeCURDSteps.updateStoresRecord(id,name, type, address, address2, city, state, zip);
        storeId = response.extract().path("id");
        System.out.println(storeId);
    }
}
