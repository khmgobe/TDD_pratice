package io.practice.tdd.product.feature;

import io.practice.tdd.product.domain.RegisterProduct;
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
    void registerProduct() {
        final long productId = 1L;
        final String productName = "productName";
        final String productDescription = "productDescription";

        RegisterProduct.Request request = new RegisterProduct.Request(productName, productDescription);

        registerProduct.request(request);
    }
}