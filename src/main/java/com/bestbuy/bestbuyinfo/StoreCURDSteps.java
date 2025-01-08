package com.bestbuy.bestbuyinfo;

import com.bestbuy.constants.EndPoint;
import com.bestbuy.model.BestBuyPojo;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Step;

import static io.restassured.RestAssured.given;

public class StoreCURDSteps {

    @Step("This method will get list of stores record")
    public ValidatableResponse getListOfStoresRecord() {
        return given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .get(EndPoint.GET_ALL_LIST_STORES)
                .then().log().all().statusCode(200);
        // id = response.extract().path("data[0].id");
        //response.body("data[0].id",equalTo(id));
    }

    @Step("This method will get stores by id")
    public ValidatableResponse getStoresById(int id) {
        return given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", id)
                .when()
                .get(EndPoint.GET_STORES_BY_ID)
                .then().log().all().statusCode(200);
    }

    @Step("This method will create new record")
    public ValidatableResponse createRecordForStore(String createName, String createType, String createAddress, String createAddress2, String createCity, String createState, String createZip) {

        BestBuyPojo bestBuyPojo = new BestBuyPojo();
        bestBuyPojo.setName(createName);
        bestBuyPojo.setType(createType);
        bestBuyPojo.setAddress(createAddress);
        bestBuyPojo.setAddress2(createAddress2);
        bestBuyPojo.setCity(createCity);
        bestBuyPojo.setState(createState);
        bestBuyPojo.setZip(createZip);

        return given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .body(bestBuyPojo)
                .post(EndPoint.CREATE_RECORD)
                .then().log().all().statusCode(201);
    }

    @Step("This method will update record")
    public ValidatableResponse updateStoresRecord(int id, String createName, String createType, String createAddress, String createAddress2, String createCity, String createState, String createZip) {
        BestBuyPojo bestBuyPojo = new BestBuyPojo();
        bestBuyPojo.setName(createName + "updated");
        bestBuyPojo.setType(createType + "updated");
        bestBuyPojo.setAddress(createAddress + "updated");
        bestBuyPojo.setAddress2(createAddress2);
        bestBuyPojo.setCity(createCity + "updated");
        bestBuyPojo.setState(createState);
        bestBuyPojo.setZip(createZip);

        return given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", id)
                .when()
                .body(bestBuyPojo)
                .put(EndPoint.UPDATE_RECORD)
                .then().log().all().statusCode(200);
    }

    @Step("This method will delete record")
    public ValidatableResponse deleteRecord(int id) {
        return given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", id)
                .when()
                .delete(EndPoint.DELETE_RECORD)
                .then();
    }
}
