package base;

import config.ConfigManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecFactory {

    public static RequestSpecification getRequestSpec() {

        RequestSpecBuilder builder =
                new RequestSpecBuilder();

        builder.setBaseUri(
                ConfigManager.getBaseUrl());

        builder.addHeader(
                "Content-Type",
                "application/json");

        builder.addHeader(
                "Authorization",
                "Bearer "
                        + ConfigManager.getToken());

        return builder.build();
    }
}