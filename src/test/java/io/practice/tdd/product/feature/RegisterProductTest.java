package io.practice.tdd.product.feature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

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
    }

    private static class RegisterProduct {

        final String productName = "productName";
        final String productDescription = "productDescription";

        public record Request( String productName, String productDescription) {
            public Request {
                Assert.hasText(productName, "제품 이름은 필수입니다.");
                Assert.hasText(productDescription, "제품 설명은 필수입니다.");
            }
        }
    }
}
