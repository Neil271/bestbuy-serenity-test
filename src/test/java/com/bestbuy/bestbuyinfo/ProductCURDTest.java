package com.bestbuy.bestbuyinfo;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class ProductCURDTest extends TestBase {

    ValidatableResponse response;
    static String createName = "Duracell - AAA Batteries (4-Pack)";
    static String createType = "HardGood";
    static Double createPrice = 4.99;
    static String createUpc = "041333424019";
    static int createShipping = 0;
    static String createDescription = "Compatible with select electronic devices; AAA size; DURALOCK Power Preserve technology; 4-pack";
    static String createManufacturer = "Duracell";
    static String createModel = "MN2400B4Z";
    static String createUrl = "http://www.bestbuy.com/site/duracell-aaa-batteries-4-pack/43900.p?id=1051384074145&skuId=43900&cmp=RMXCC";
    static String createImage = "http://img.bbystatic.com/BestBuy_US/images/products/4390/43900_sa.jpg";

    static int productId;

    @Steps
    ProductCURDSteps productCURDSteps;

    @Title("Getting all products")
    @Test
    public void test001() {
        response = productCURDSteps.getListOfProductsRecord();
        productId = response.extract().path("data[0].id");
        // System.out.println(productId);
    }

    @Title("Getting product by id")
    @Test
    public void test002() {
        productCURDSteps.getProductsById(productId);
        // System.out.println(productId);
    }

    @Title("Creating new product")
    @Test
    public void test003() {
        productCURDSteps.createProductsRecord(createName, createType, createPrice, createUpc, createShipping, createDescription, createManufacturer, createModel, createUrl, createImage);
    }

    @Title("Updating product")
    @Test
    public void test004() {
        response = productCURDSteps.updateProductsRecord(productId, createName, createType, createPrice, createUpc, createShipping, createDescription, createManufacturer, createModel, createUrl, createImage);
        response.statusCode(200);
    }

    @Title("Deleting")
    @Test
    public void test005() {
        response = productCURDSteps.deleteRecord(productId);
        response.statusCode(204);
    }
}
