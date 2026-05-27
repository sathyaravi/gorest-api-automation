package services;

import base.RequestSpecFactory;
import constants.Endpoints;
import io.restassured.response.Response;
import requests.UserRequest;

import static io.restassured.RestAssured.given;

public class UserService {

    public Response createUser(UserRequest requestBody) {

        return given()
                .spec(RequestSpecFactory.getRequestSpec())
                .body(requestBody)

        .when()
                .post(Endpoints.CREATE_USER)

        .then()
                .extract().response();
    }

    public Response getUser(int userId) {

        return given()
                .spec(RequestSpecFactory.getRequestSpec())

        .when()
                .get(Endpoints.GET_USER + userId)

        .then()
                .extract().response();
    }

    public Response updateUser(int userId,
                               UserRequest requestBody) {

        return given()
                .spec(RequestSpecFactory.getRequestSpec())
                .body(requestBody)

        .when()
                .patch(Endpoints.UPDATE_USER + userId)

        .then()
                .extract().response();
    }

    public Response deleteUser(int userId) {

        return given()
                .spec(RequestSpecFactory.getRequestSpec())

        .when()
                .delete(Endpoints.DELETE_USER + userId)

        .then()
                .extract().response();
    }
    
}
