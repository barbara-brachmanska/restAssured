package com.epam.test;

import com.epam.framework.RestAssuredConfiguration;
import com.epam.test.common.EndPoint;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class Country {

    @Test
    public void validateCountry(){
        given().get("http://services.groupkt.com/country/get/all").then().statusCode(200).log().all();
    }

    @Test(groups = "demo")
    public void validateCountry2(){
        given().get(EndPoint.GET_COUNTRY).then().statusCode(200).log().all();
    }

    @Test(groups = {"demo", "response"})
    public void validatePathParameter(){
        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
        requestSpecification.pathParam("name", "Poland").log().all();
        given().spec(requestSpecification).get(EndPoint.GET_COUNTRY_PATH_PARAMETER).then().statusCode(200).log().all();

        //Getting response
        Response response = given().spec(requestSpecification).get(EndPoint.GET_COUNTRY_PATH_PARAMETER);
        //Inline validation
        //1.Hard Assertion
      //  Assert.assertEquals(response.path("name"),"Poland");

        //soft assertion
        SoftAssert softAssert = new SoftAssert();
        //System.out.println( response.path("name"));
        softAssert.assertEquals(((ArrayList<String>) response.path("name")).get(0), "Poland", "Name not equal");
        softAssert.assertEquals(((ArrayList<String>) response.path("capital")).get(0), "Warsaw", "Capital not equal");
        softAssert.assertAll();
//Java object
      /*  Poland country = response.as(Poland.class);
        Assert.assertEquals(country.getName(),"Poland");*/
    }

}
