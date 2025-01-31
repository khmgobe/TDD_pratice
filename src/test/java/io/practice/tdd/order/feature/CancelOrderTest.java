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
    }

    private class CancelOrderService {

        public void cancelOrder() {

        }
    }

    private class FakeOrderRepository {
    }
}
