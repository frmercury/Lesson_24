package com.ex.api;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.lang.reflect.Type;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApiSuite extends BaseTest {

    @Test
    public void getUsersTest() {
       Map<String, Object> mapUsers = usersRequests
               .getUsersRequest("11d16dd3d264220f123d1d9bab1a51491ed15f79b1dc290af2024c128235ff8c",
                       "/users", 200);

       Response response = (Response) mapUsers.get("response");
       assertThat(response.contentType()).isEqualTo("application/json; charset=utf-8");
    }

    @Test
    public void postUsersTest() {
       Map<String, Object> mapUsers = usersRequests
               .postUsersRequest("11d16dd3d264220f123d1d9bab1a51491ed15f79b1dc290af2024c128235ff8c",
                       "/users", 201, "{\"name\":\"island22\",\"email\":\"dharma23@GMAIL.COM\",\"gender\":\"female\",\"status\":\"active\"}");

       String response = (String) mapUsers.get("json");

       JsonObject jsonObject = new Gson().fromJson(response, JsonObject.class);

       System.out.println("id = " + jsonObject.get("id"));
       assertThat(jsonObject.get("name")).asString().isEqualTo("\"island22\"");
       assertThat(jsonObject.get("email")).asString().isEqualTo("\"dharma23@GMAIL.COM\"");
    }
}