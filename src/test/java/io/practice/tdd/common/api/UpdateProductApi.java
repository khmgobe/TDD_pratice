package io.practice.tdd.common.api;

import io.practice.tdd.common.Scenario;
import io.practice.tdd.product.dto.request.UpdateProductRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class UpdateProductApi {

    public ExtractableResponse<Response> request() {

        Scenario.registerProduct().request();

        final Long productId = 1L;
        final String productName = "변경한 상품 이름";
        final String productDescription = "변경한 상품 설명";

        UpdateProductRequest request = new UpdateProductRequest(productName, productDescription);

        final ExtractableResponse<Response> response = RestAssured.given().log().all()
                .body(request)
                .contentType(ContentType.JSON)
                .when()
                .patch("/products/{productId}", productId)
                .then()
                .log().all().extract();

        return response;
    }
}
