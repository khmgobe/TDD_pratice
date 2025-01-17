package io.practice.tdd.common.api;

import io.practice.tdd.common.Scenario;
import io.practice.tdd.product.feature.RegisterProduct;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.springframework.http.HttpStatus;

public class RegisterProductApi {

    String productName = "productName";
    String productDescription = "productDescription";

    public RegisterProductApi productName(final String productName) {
        this.productName = productName;
        return this;
    }

    public RegisterProductApi productDescription(final String productDescription) {
        this.productDescription = productDescription;
        return this;
    }


    public Scenario request() {
        RegisterProduct.Request request = new RegisterProduct.Request(productName, productDescription);

        /** RestAssured -> given (log() & all(), when (post() 등, then(log() & all() & HttpStatusCode) 등으로 나눌 수 있다.) **/
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
