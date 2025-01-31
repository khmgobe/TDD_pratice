package io.practice.tdd.order.feature;

import io.practice.tdd.common.ApiTest;
import io.practice.tdd.common.Scenario;
import io.practice.tdd.order.out.persistence.OrderRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class CancelOrderTest extends ApiTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    @DisplayName("주문을 등록하고 등록한 주문을 취소한다.")
    void cancelOrder() {
        final Long orderId = 1L;


        // given: 상품을 생성하고 상품 정보 기반으로 주문을 등록한다.
        Scenario.registerProduct().request();
        Scenario.registerOrder().request();

        Assertions.assertThat(orderRepository.findAll()).hasSize(1);
    }
}
