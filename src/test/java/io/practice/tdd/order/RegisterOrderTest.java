package io.practice.tdd.order;


import io.practice.tdd.product.domain.Product;
import io.practice.tdd.product.util.ProductSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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

        RegisterOrderRequest orderRequest = new RegisterOrderRequest(id, product, quantity);

        registerOrder.register(orderRequest);
    }

    private class RegisterOrder {

        private final OrderRepository orderRepository;

        private RegisterOrder(final OrderRepository orderRepository) {
            this.orderRepository = orderRepository;
        }

        public void register(final RegisterOrderRequest request) {

        }
    }

    private record RegisterOrderRequest(Long id,
                                        Product product,
                                        Integer quantity) {

        public RegisterOrderRequest {
            Assert.notNull(id, "아이디는 필수입니다.");
            Assert.notNull(product, "상품은 필수입니다.");
            Assert.notNull(quantity, "수량은 필수입니다.");
        }
    }

    private class Order {

        Long id;
        final Product product;
        final int quantity;
        final LocalDateTime createAt;
        final LocalDateTime cancelAt;

        public Order(
                final Long id,
                final Product product,
                final int quantity,
                final LocalDateTime createAt,
                final LocalDateTime cancelAt) {

            this.id = id;
            this.product = product;
            this.quantity = quantity;
            this.createAt = createAt;
            this.cancelAt = cancelAt;

            validateConstructor(id, product, quantity, createAt, cancelAt);
        }

        private void validateConstructor(final Long id,
                                         final Product product,
                                         final int quantity,
                                         final LocalDateTime createAt,
                                         final LocalDateTime cancelAt) {

            Assert.notNull(id, "아이디는 필수입니다.");
            Assert.notNull(product, "상품은 필수입니다.");
            Assert.notNull(quantity, "수량은 필수입니다.");
            Assert.notNull(createAt, "생성 일자는 필수입니다.");
            Assert.notNull(cancelAt, "취소 일자는 필수입니다.");
        }

        public void assignId(final Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }
    }

    private class OrderRepository {

        private final Map<Long, Order> orderMap = new HashMap<>();
        private Long sequence = 1L;

        public void save(final Order order) {
            order.assignId(sequence++);
            orderMap.put(order.getId(), order);
        }
    }
}
