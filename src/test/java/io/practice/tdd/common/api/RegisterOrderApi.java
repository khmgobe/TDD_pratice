package io.practice.tdd.common.api;

import io.practice.tdd.common.Scenario;
import io.practice.tdd.order.RegisterOrderRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.springframework.http.HttpStatus;

public class RegisterOrderApi {

    final Long productId = 1L;
    final int quantity = 5;

    RegisterOrderRequest request = new RegisterOrderRequest(quantity);

    public Scenario request() {

        final ValidatableResponse response =
                RestAssured.given()
                        .log()
                        .all()
                        .when()
                        .body(request)
                        .contentType(ContentType.JSON)
                        .when()
                        .post("/orders/{productId}", productId)
                        .then()
                        .log()
                        .all()
                        .statusCode(HttpStatus.CREATED.value());

        return new Scenario();
    }
}
