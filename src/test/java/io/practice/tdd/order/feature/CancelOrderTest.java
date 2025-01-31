package io.practice.tdd.order.feature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

class CancelOrderTest {

    private CancelOrderService cancelOrderService;
    private FakeOrderRepository fakeOrderRepository;

    @BeforeEach
    void setUp() {
        cancelOrderService = new CancelOrderService();
    }

    @Test
    @DisplayName("주문을 취소한다.")
    void cancelOrder() {
        cancelOrderService.cancelOrder();
        final Long orderId = 1L;
        final String orderName = "orderName";
        final String orderDescription = "orderDescription";

        FakeOrderRequest fakeOrderRequest = new FakeOrderRequest(orderName, orderDescription);
    }

    private class CancelOrderService {

        public void cancelOrder() {

        }
    }

    private class FakeOrderRepository {

    }

    private class FakeOrder {

        final Long id;
        final String orderName;
        final String orderDescription;

        public FakeOrder(final Long id, final String orderName, final String orderDescription) {
            this.id = id;
            this.orderName = orderName;
            this.orderDescription = orderDescription;
        }
    }

    private record FakeOrderRequest(
            String orderName,
            String orderDescription) {

        public FakeOrderRequest {
            Assert.notNull(orderName, "주문 이름은 필수입니다.");
            Assert.notNull(orderDescription, "주문 정보는 필수입니다.");
        }
    }
}
