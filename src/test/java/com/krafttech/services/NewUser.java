package com.krafttech.services;

import com.github.javafaker.Faker;
import com.krafttech.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class NewUser {

    Response response;
    Faker faker = new Faker();
    public static String userName;

    public static String password;
    public static String userID;

    public static String token;

    public void userRegister() {
        password = ConfigurationReader.get("commonPassword");
        userName = faker.name().fullName();

       /*
       {
  "userName": "ddddddddd",
  "password": "ddddddddd"
        }
        */

        Map<String, Object> body = new HashMap<>();
        body.put("userName", userName);
        body.put("password", password);

        response = RestAssured.given().contentType(ContentType.JSON)
                .body(body).log().all()
                .when()
                .post("/Account/v1/User").prettyPeek();

        userID = response.path("userID");
        System.out.println("userID = " + userID);

    }
    public void verifyRegisterStatusCode(){
        response.then().statusCode(201);
    }

    public void generateToken(){
        /*
        {
  "userName": "string",
  "password": "string"
}
         */

        Map<String ,Object> body=new HashMap<>();
        body.put("userName",userName);
        body.put("password",password);

        response= RestAssured.given().contentType(ContentType.JSON)
                .body(body).log().all()
                .when()
                .post("/Account/v1/GenerateToken").prettyPeek();

        token=response.path("token");
        System.out.println("token = " + token);
    }

    public void verifyGenerateTokenStatusCode(){
        response.then().statusCode(200);
    }

    public void userAuthorized(){
        /*
        {
  "userName": "string",
  "password": "string"
}
         */


        Map<String ,Object> body=new HashMap<>();
        body.put("userName",userName);
        body.put("password",password);

        Map<String,Object> tokenMap=new HashMap<>();
        tokenMap.put("Authorization","Bearer "+token);

        response= RestAssured.given().contentType(ContentType.JSON)
                .headers(tokenMap)
                .body(body)
                .when().log().all()
                .post("/Account/v1/Authorized").prettyPeek();
    }

    public void verifyAuthorizedStatusCode(){
        response.then().statusCode(200);
    }

    public void getUser(){
        Map<String,Object> tokenMap=new HashMap<>();
        tokenMap.put("Authorization","Bearer "+ token);

        response= RestAssured.given().contentType(ContentType.JSON)
                .pathParam("id",userID)
                .headers(tokenMap)
                .when().log().all()
                .get("/Account/v1/User/{id}").prettyPeek();
    }
    public void verifyUserById(){
        response.then().statusCode(200);
    }

    public void addBooks(){
        Map<String,Object> tokenMap=new HashMap<>();
        tokenMap.put("Authorization","Bearer "+ token);

        String body="{\n" +
                "  \"userId\": \""+ userID +"\",\n" +
                "  \"collectionOfIsbns\": [\n" +
                "    {\n" +
                "      \"isbn\": \""+ConfigurationReader.get("isbn2")+"\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        response= RestAssured.given().contentType(ContentType.JSON)
                .headers(tokenMap)
                .body(body)
                .when().log().all()
                .post("/BookStore/v1/Books").prettyPeek();
    }

    public void verifyAddBooks(){
        response.then().statusCode(201);
    }

    public void updateBook(){
        String body="{\n" +
                "  \"userId\": \""+ userID +"\",\n" +
                "  \"isbn\": \""+ConfigurationReader.get("isbn7")+"\"\n" +
                "}";

        Map<String,Object> tokenMap=new HashMap<>();
        tokenMap.put("Authorization","Bearer "+ token);

        response= RestAssured.given().contentType(ContentType.JSON)
                .pathParam("isbn",ConfigurationReader.get("isbn2"))
                .headers(tokenMap)
                .body(body)
                .when().log().all()
                .put("/BookStore/v1/Books/{isbn}").prettyPeek();
    }

    public void verifyUpdateBookStatus(){
        response.then().statusCode(200);
    }

    public void deleteABook(){

        String body="{\n" +
                "  \"isbn\": \""+ ConfigurationReader.get("isbn7") +"\",\n" +
                "  \"userId\": \""+userID+"\"\n" +
                "}";

        Map<String,Object> tokenMap=new HashMap<>();
        tokenMap.put("Authorization","Bearer "+ token);

        response= RestAssured.given().contentType(ContentType.JSON)
                .headers(tokenMap)
                .body(body)
                .when().log().all()
                .delete("/BookStore/v1/Book").prettyPeek();
    }

    public void verifyDelete() {
        response.then().statusCode(204);

    }
}



