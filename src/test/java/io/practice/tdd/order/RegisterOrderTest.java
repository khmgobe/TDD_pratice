package io.practice.tdd.order;


import io.practice.tdd.common.ApiTest;
import io.practice.tdd.product.domain.Product;
import io.practice.tdd.product.util.ProductSteps;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

class RegisterOrderTest extends ApiTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    @DisplayName("상품의 데이터로 주문을 등록한다.")
    void registerOrder() {

        final Long id = 1L;
        final Product product = ProductSteps.productBuilder();
        final int quantity = 5;

        RegisterOrderRequest request = new RegisterOrderRequest(product, quantity);

        final ValidatableResponse response = RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("/orders")
                .then()
                .log().all()
                .statusCode(HttpStatus.CREATED.value());

        assertThat(orderRepository.findAll()).hasSize(1);

    }
}
