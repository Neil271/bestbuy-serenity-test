package com.bestbuy.bestbuyinfo;

import com.bestbuy.constants.EndPoint;
import com.bestbuy.model.BestBuyPojo1;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Step;

import static io.restassured.RestAssured.given;

public class ProductCURDSteps {

    @Step("This method will get list of products record")
    public ValidatableResponse getListOfProductsRecord() {
        return given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .get(EndPoint.GET_ALL_LIST_PRODUCTS)
                .then().log().all().statusCode(200);
    }

    @Step("This method will get products by id")
    public ValidatableResponse getProductsById(int id) {
        return given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", id)
                .when()
                .get(EndPoint.GET_PRODUCTS_BY_ID)
                .then().log().all().statusCode(200);
    }

    @Step("This method will create new record")
    public ValidatableResponse createProductsRecord(String name, String type, Double price, String upc, int shipping, String desc, String manu, String model, String url, String image) {

        BestBuyPojo1 bestBuyPojo1 = new BestBuyPojo1();
        bestBuyPojo1.setName(name);
        bestBuyPojo1.setType(type);
        bestBuyPojo1.setPrice(price);
        bestBuyPojo1.setUpc(upc);
        bestBuyPojo1.setShipping(shipping);
        bestBuyPojo1.setDescription(desc);
        bestBuyPojo1.setManufacturer(manu);
        bestBuyPojo1.setModel(model);
        bestBuyPojo1.setUrl(url);
        bestBuyPojo1.setImage(image);

        return given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .body(bestBuyPojo1)
                .post(EndPoint.CREATE_PRODUCTS_RECORD)
                .then().log().all().statusCode(201);
    }

    @Step("This method will update record")
    public ValidatableResponse updateProductsRecord(int id, String name, String type, Double price, String upc, int shipping, String desc, String manu, String model, String url, String image) {
        BestBuyPojo1 bestBuyPojo1 = new BestBuyPojo1();
        bestBuyPojo1.setName(name + "updated");
        bestBuyPojo1.setType(type + "updated");
        bestBuyPojo1.setPrice(price);
        bestBuyPojo1.setUpc(upc);
        bestBuyPojo1.setShipping(shipping);
        bestBuyPojo1.setDescription(desc);
        bestBuyPojo1.setManufacturer(manu + "updated");
        bestBuyPojo1.setModel(model + "updated");
        bestBuyPojo1.setUrl(url);
        bestBuyPojo1.setImage(image);

        return given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", id)
                .when()
                .body(bestBuyPojo1)
                .put(EndPoint.UPDATE_PRODUCTS_RECORD)
                .then().log().all().statusCode(200);
    }

    @Step("This method will delete record")
    public ValidatableResponse deleteRecord(int id) {
        return given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", id)
                .when()
                .delete(EndPoint.DELETE_PRODUCTS_RECORD)
                .then().log().all()
                .statusCode(200);
    }

}
