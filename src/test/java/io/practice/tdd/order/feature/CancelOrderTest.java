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
        FakeOrder fakeOrder = new FakeOrder(1L, "orderName", "orderDescription");
    }

    private class CancelOrderService {

        public void cancelOrder() {

        }
    }

    private class FakeOrderRepository {

    }

    private class FakeOrder {

        final long id;
        final String orderName;
        final String orderDescription;

        public FakeOrder(final long id, final String orderName, final String orderDescription) {
        this.id = id;
        this.orderName = orderName;
        this.orderDescription = orderDescription;
        }
    }
}
