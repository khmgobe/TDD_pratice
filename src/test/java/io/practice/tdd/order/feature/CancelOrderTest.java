package io.practice.tdd.order.feature;

import io.practice.tdd.common.ApiTest;
import io.practice.tdd.common.Scenario;
import io.practice.tdd.order.application.CancelOrderService;
import io.practice.tdd.order.out.persistence.OrderRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

class CancelOrderTest extends ApiTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CancelOrderService cancelOrderService;

    @Test
    @DisplayName("주문을 등록하고 등록한 주문을 취소한다.")
    void cancelOrder() {
        final Long orderId = 1L;

        // given: 상품을 생성하고 상품 정보 기반으로 주문을 등록한다.
        Scenario.registerProduct().request();
        Scenario.registerOrder().request();

        // when: 주문 아이디를 기반으로 주문을 취소한다.
        RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .when()
                .delete("/orders/{orderId}", orderId)
                .then().log().all()
                .statusCode(HttpStatus.OK.value());

        // then: 주문 취소가 이루어졌는지 확인한다.
        Assertions.assertThat(orderRepository.findAll()).hasSize(0);

    }
}
