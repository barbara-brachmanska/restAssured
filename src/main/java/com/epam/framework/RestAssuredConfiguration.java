package com.epam.framework;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;

public class RestAssuredConfiguration {

   @BeforeSuite(alwaysRun = true)
    public void configure(){
//        RestAssured.baseURI = "http://services.groupkt.com";
//        RestAssured.basePath = "/country";
       RestAssured.baseURI = "http://restcountries.eu";
       RestAssured.basePath = "/rest";

   }

    public RequestSpecification getRequestSpecification() {
       return RestAssured.given().contentType(ContentType.JSON);
    }
}
