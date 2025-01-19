package io.practice.tdd.common.api;

import io.practice.tdd.common.Scenario;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class DeleteProductApi {

    final Long productId = 1L;

    public ExtractableResponse<Response> request() {

        Scenario.registerProduct().request();

        final ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .when()
                .delete("/products/{productId}", productId)
                .then().log().all().extract();

        return response;
    }
}
