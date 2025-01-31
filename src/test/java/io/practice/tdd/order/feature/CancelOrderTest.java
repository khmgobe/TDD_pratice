package io.practice.tdd.order.feature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CancelOrderTest {

    private CancelOrderService cancelOrderService;
    private FakeOrderRepository fakeOrderRepository;

    @BeforeEach
    void setUp() {
        cancelOrderService = new CancelOrderService();
    }

    @Test
    @DisplayName("주문을 취소한다.")
    void cancelOrder()  {
        cancelOrderService.cancelOrder();
        final Long orderId = 1L;
        final String orderName = "orderName";
        final String orderDescription = "orderDescription";


        FakeOrder fakeOrder = new FakeOrder(orderId, orderName, orderDescription);
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
}
