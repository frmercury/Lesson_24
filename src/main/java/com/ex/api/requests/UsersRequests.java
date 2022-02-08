package com.ex.api.requests;

import io.restassured.response.Response;
import org.assertj.core.api.Assertions;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersRequests extends BaseRequests {
    public Map<String, Object> getUsersRequest (String token, String resource, int expectedSC) {
        Response response = getMethods
                .withToken(token,resource);
        assertThat(response.statusCode()).isEqualTo(expectedSC);
        return new HashMap<String, Object>() {
            {
                put("response", response);
                put("json", response.toString());
            }
        };
    }
    public Map<String, Object> postUsersRequest (String token, String resource, int expectedSC, String body) {
        Response response = postMethods
                .withToken(token,resource,body);
        assertThat(response.statusCode()).isEqualTo(expectedSC);
        return new HashMap<String, Object>() {
            {
                put("response", response);
                put("json", response.asString());
            }
        };
    }
}
