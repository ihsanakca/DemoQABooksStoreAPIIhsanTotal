package com.krafttech.services;

import com.krafttech.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class GetBooks {
Response response;
    public void bookList(){
        Map<String,Object> tokenMap=new HashMap<>();
        tokenMap.put("Authorization","Bearer "+ ConfigurationReader.get("token"));

        response=RestAssured.given()
                .contentType(ContentType.JSON)
                .headers(tokenMap)
                .when().log().all()
                .get("/BookStore/v1/Books").prettyPeek();
    }

    public void verifyBookList(){
        response.then().statusCode(200);
    }
}
