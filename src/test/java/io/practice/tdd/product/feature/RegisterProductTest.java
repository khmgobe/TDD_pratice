package io.practice.tdd.product.feature;

import io.practice.tdd.common.ApiTest;
import io.practice.tdd.product.domain.ProductRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

class RegisterProductTest extends ApiTest {


    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("프로덕트를 등록한다")
    void registerProduct() {
        final String productName = "productName";
        final String productDescription = "productDescription";

        RegisterProduct.Request request = new RegisterProduct.Request(productName, productDescription);

        // RestAssured -> given (log() & all(), when (post() 등, then(log() & all() & HttpStatusCode) 등으로 나눌 수 있다.)
        RestAssured
                .given().log().all()
                .body(request)
                .contentType(ContentType.JSON)
                .when()
                .post("/products")
                .then().log().all()
                .statusCode(HttpStatus.CREATED.value());

        assertThat(productRepository.findAll()).hasSize(1);
    }
}