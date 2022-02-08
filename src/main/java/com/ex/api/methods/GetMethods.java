package com.ex.api.methods;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetMethods {
    public Response withToken (String token, String resource){
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        return given()
                .auth().oauth2(token)
                .when()
                .get(resource)
                .then()
                .extract()
                .response();
    }
}