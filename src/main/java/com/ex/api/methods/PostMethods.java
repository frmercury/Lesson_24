package com.ex.api.methods;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.openqa.selenium.json.Json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import static io.restassured.RestAssured.given;

public class PostMethods {


    public Response withToken (String token, String resource, String body) {

//        JSONObject jsonObj = new JSONObject()
//                .put("name","losted3425")
//                .put("email","loooo213423@GMAIL.COM")
//                .put("gender","female")
//                .put("status","active");
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        return given()
                .auth().oauth2(token)
                .contentType("application/json")
                .body(body)
                .when()
                .post(resource)
                .then()
                .extract()
                .response();
        }


    }
