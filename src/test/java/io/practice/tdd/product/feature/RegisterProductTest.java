package io.practice.tdd.product.feature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RegisterProductTest {


    private RegisterProduct registerProduct;

    @BeforeEach
    void setUp() {
        registerProduct = new RegisterProduct();
    }

    @Test
    @DisplayName("프로덕트를 등록한다")
    void registerProduct()  {
        RegisterProduct.Request request = new RegisterProduct.Request();
    }

    private static class RegisterProduct {

        public record Request() {
        }
    }
}
