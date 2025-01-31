package io.practice.tdd.common.api;

import io.practice.tdd.common.Scenario;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.springframework.http.HttpStatus;

public class CancelOrderApi {

    private final Long orderId = 1L;

    public Scenario request() {

        final ValidatableResponse response = RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .when()
                .delete("/orders/{orderId}", orderId)
                .then().log().all()
                .statusCode(HttpStatus.OK.value());

        return new Scenario();
    }
}
