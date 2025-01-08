package com.bestbuy.cucumber.steps;

import com.bestbuy.bestbuyinfo.ProductCURDSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;

public class ProductSteps {

    ValidatableResponse response;
    static int productId;


    @Steps
    ProductCURDSteps productCURDSteps;

    @Given("Bestbuy Application is running")
    public void bestbuyApplicationIsRunning() {
    }

    @When("I create a new product using name {string} type {string} price {} upc {string} shipping {int} desc {string} manu {string} model {string} url {string} image {string}")
    public void iCreateANewProductUsingNameTypePriceUpcShippingDescManuModelUrlImage(String name, String type, Double price, String upc, int shipping, String desc, String manu, String model, String url, String image) {
        response=productCURDSteps.createProductsRecord(name,type,price,upc,shipping,desc,manu,model,url,image);
        //productId=response.extract().path("data[8].id");
    }

    @And("I delete the product that created with id")
    public void iDeleteTheProductThatCreatedWithId() {
        productCURDSteps.deleteRecord(productId);
    }

    @Then("The product deleted successfully from the application")
    public void theProductDeletedSuccessfullyFromTheApplication() {
        response.statusCode(204);
    }
}
