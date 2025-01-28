package io.practice.tdd.order;


import io.practice.tdd.product.domain.Product;
import io.practice.tdd.product.util.ProductSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

class RegisterOrderTest {


    private RegisterOrder registerOrder;

    @BeforeEach
    void setUp() {
        registerOrder = new RegisterOrder();
    }

    @Test
    @DisplayName("상품의 데이터로 주문을 등록한다.")
    void registerOrder() {

        final Long id = 1L;
        final Product product = ProductSteps.productBuilder();
        final int quantity = 5;

        Request request = new Request(id, product, quantity);
    }

    private class RegisterOrder {
    }

    private record Request(Long id,
                           Product product,
                           Integer quantity) {
        public Request {
            Assert.notNull(id, "아이디는 필수입니다.");
            Assert.notNull(product, "상품은 필수입니다.");
            Assert.notNull(quantity, "수량은 필수입니다.");
        }
    }
}
