package io.practice.tdd.order;


import io.practice.tdd.common.ApiTest;
import io.practice.tdd.common.Scenario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class RegisterOrderTest extends ApiTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    @DisplayName("상품의 데이터로 주문을 등록한다.")
    void registerOrder() {

        Scenario.registerProduct().request();
        Scenario.registerOrder().request();

        assertThat(orderRepository.findAll()).hasSize(1);
    }
}
