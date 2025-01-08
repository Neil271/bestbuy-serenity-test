package com.bestbuy.bestbuyinfo;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Title;
import org.junit.Test;

//@RunWith(SerenityRunner.class)
public class StoreCURDTest extends TestBase {

    ValidatableResponse response;
    static int storeId;
    static String createName = "palakk";
    static String createType = "BigBox233";
    static String createAddress = "135135644 Ridgedale Dr";
    static String createAddress2 = "";
    static String createCity = "Sussex";
    static String createState = "MN";
    static String createZip = "56788";

    @Steps
    StoreCURDSteps storeCURDSteps;

    @Title("Getting all stores")
    @Test
    public void test001() {
        response = storeCURDSteps.getListOfStoresRecord();
        storeId = response.extract().path("data[0].id");
    }

    @Title("Getting store by id")
    @Test
    public void test002() {
        storeCURDSteps.getStoresById(storeId);
    }

    @Title("Creating new record")
    @Test
    public void test003() {
        storeCURDSteps.createRecordForStore(createName, createType, createAddress, createAddress2, createCity, createState, createZip);
    }

    @Title("Updating record")
    @Test
    public void test004() {
        response = storeCURDSteps.updateStoresRecord(storeId, createName, createType, createAddress, createAddress2, createCity, createState, createZip);
        response.statusCode(200);
    }

    @Title("Deleting record")
    @Test
    public void test005() {
        response = storeCURDSteps.deleteRecord(storeId);
        response.statusCode(204);
    }
}
