package io.practice.tdd.common.api;

import io.practice.tdd.common.Scenario;
import io.practice.tdd.product.domain.enumeration.DiscountPolicy;
import io.practice.tdd.product.dto.request.RegisterProductRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.springframework.http.HttpStatus;

public class RegisterProductApi {

    String productName = "productName";
    String productDescription = "productDescription";
    Long productPrice = 10000L;
    Integer productQuantity = 5;
    DiscountPolicy discountPolicy = DiscountPolicy.NONE;

    public Scenario request() {
        RegisterProductRequest request = new RegisterProductRequest(
                productName,
                productDescription,
                productPrice,
                productQuantity,
                discountPolicy);

        RestAssured
                .given().log().all()
                .body(request)
                .contentType(ContentType.JSON)
                .when()
                .post("/products")
                .then().log().all()
                .statusCode(HttpStatus.CREATED.value());

        return new Scenario();
    }
}
