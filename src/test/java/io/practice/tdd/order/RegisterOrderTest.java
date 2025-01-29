package io.practice.tdd.order;


import io.practice.tdd.product.domain.Product;
import io.practice.tdd.product.util.ProductSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RegisterOrderTest {


    private RegisterOrder registerOrder;
    private OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        orderRepository = new OrderRepository();
        registerOrder = new RegisterOrder(orderRepository);
    }

    @Test
    @DisplayName("상품의 데이터로 주문을 등록한다.")
    void registerOrder() {

        final Long id = 1L;
        final Product product = ProductSteps.productBuilder();
        final int quantity = 5;

        RegisterOrderRequest orderRequest = new RegisterOrderRequest(product, quantity);

        registerOrder.register(orderRequest);

        assertThat(orderRepository.findAll()).hasSize(1);
    }
}
