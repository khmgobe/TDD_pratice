package io.practice.tdd.order;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RegisterOrderTest {


    @Test
    @DisplayName("상품의 데이터로 주문을 등록한다.")
    void registerOrder()  {
        RegisterOrder registerOrder = new RegisterOrder();
    }

    private class RegisterOrder {
    }
}
