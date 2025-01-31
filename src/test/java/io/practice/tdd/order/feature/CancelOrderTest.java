package io.practice.tdd.order.feature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CancelOrderTest {


    private CancelOrderService cancelOrderService;

    @BeforeEach
    void setUp() {
        cancelOrderService = new CancelOrderService();
    }

    @Test
    @DisplayName("주문을 취소한다.")
    void cancelOrder()  {

    }

    private class CancelOrderService {
    }
}
