package tests;

import com.fasterxml.jackson.databind.JsonNode;

import io.qameta.allure.Description;

import io.restassured.module.jsv.JsonSchemaValidator;

import io.restassured.response.Response;

import requests.UserRequest;
import response.UserResponse;

import org.testng.Assert;
import org.testng.annotations.Test;

import services.UserService;

import utils.JsonDataReader;

public class UserTests {

    UserService userService = new UserService();

    static int userId;

    /*
     ---------------------------------------------
     CREATE USER POSITIVE
     ---------------------------------------------
     */

    @Test(priority = 1)

    @Description("Create User Positive Test")

    public void createUserPositive() {

        JsonNode data =
                JsonDataReader.getTestData(
                        "createUserPositive");

        UserRequest request =
                new UserRequest();

        request.setName(
                data.get("name").asText());

        request.setEmail(
                "user"
                        + System.currentTimeMillis()
                        + "@gmail.com");

        request.setGender(
                data.get("gender").asText());

        request.setStatus(
                data.get("status").asText());

        Response response =
                userService.createUser(request);

        response.then().statusCode(201);

        response.then().body(
                JsonSchemaValidator
                        .matchesJsonSchemaInClasspath(
                                "schemas/user-schema.json"));

        UserResponse userResponse =
                response.as(UserResponse.class);

        userId = userResponse.getId();

        System.out.println(
                "Created User ID : "
                        + userId);

        Assert.assertEquals(
                userResponse.getName(),
                request.getName());
    }

    /*
     ---------------------------------------------
     CREATE USER NEGATIVE
     ---------------------------------------------
     */

    @Test(priority = 2)

    public void createUserNegative() {

        UserRequest request =
                new UserRequest();

        request.setName("");

        request.setEmail("wrongmail");

        Response response =
                userService.createUser(request);

        response.then().statusCode(422);
    }

    /*
     ---------------------------------------------
     GET USER POSITIVE
     ---------------------------------------------
     */

    @Test(priority = 3)

    @Description("Get User Positive Test")

    public void getUserPositive() {

        Response response =
                userService.getUser(userId);

        response.then().statusCode(200);

        UserResponse userResponse =
                response.as(UserResponse.class);

        Assert.assertEquals(
                userResponse.getId(),
                userId);

        System.out.println(
                "Fetched User Name : "
                        + userResponse.getName());
    }

    /*
     ---------------------------------------------
     GET USER NEGATIVE
     ---------------------------------------------
     */

    @Test(priority = 4)

    public void getUserNegative() {

        Response response =
                userService.getUser(99999999);

        response.then().statusCode(404);
    }

    /*
     ---------------------------------------------
     UPDATE USER POSITIVE
     ---------------------------------------------
     */

    @Test(priority = 5)

    @Description("Update User Positive Test")

    public void updateUserPositive() {

        JsonNode data =
                JsonDataReader.getTestData(
                        "updateUserPositive");

        UserRequest request =
                new UserRequest();

        request.setName(
                data.get("name").asText());

        request.setEmail(
                "updated"
                        + System.currentTimeMillis()
                        + "@gmail.com");

        request.setGender(
                data.get("gender").asText());

        request.setStatus(
                data.get("status").asText());

        Response response =
                userService.updateUser(
                        userId,
                        request);

        response.then().statusCode(200);

        UserResponse userResponse =
                response.as(UserResponse.class);

        Assert.assertEquals(
                userResponse.getName(),
                request.getName());

        System.out.println(
                "Updated User Name : "
                        + userResponse.getName());
    }

    /*
     ---------------------------------------------
     UPDATE USER NEGATIVE
     ---------------------------------------------
     */

    @Test(priority = 6)

    public void updateUserNegative() {

        UserRequest request =
                new UserRequest();

        request.setEmail("invalidmail");

        Response response =
                userService.updateUser(
                        userId,
                        request);

        response.then().statusCode(422);
    }

    /*
     ---------------------------------------------
     DELETE USER POSITIVE
     ---------------------------------------------
     */

    @Test(priority = 7)

    @Description("Delete User Positive Test")

    public void deleteUserPositive() {

        Response response =
                userService.deleteUser(userId);

        response.then().statusCode(204);

        System.out.println(
                "Deleted User ID : "
                        + userId);
    }

    /*
     ---------------------------------------------
     DELETE USER NEGATIVE
     ---------------------------------------------
     */

    @Test(priority = 8)

    public void deleteUserNegative() {

        Response response =
                userService.deleteUser(99999999);

        response.then().statusCode(404);
    }
}