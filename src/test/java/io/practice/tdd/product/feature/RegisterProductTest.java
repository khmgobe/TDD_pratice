package io.practice.tdd.product.feature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

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

    private static class RegisterProduct {

        private String productName = "productName";
        private String productDescription = "productDescription";
        private RegisterRepository registerRepository;

        public void request(final Request request) {
            registerRepository.save(request.toDomain());
        }

        public record Request(String productName, String productDescription) {
            public Request {
                Assert.hasText(productName, "제품 이름은 필수입니다.");
                Assert.hasText(productDescription, "제품 설명은 필수입니다.");
            }

            public Product toDomain() {
                return new Product(productName, productDescription);
            }
        }
    }

    private static class Product {
        private final String productName;
        private final String productDescription;

        public Product(final String productName,
                       final String productDescription) {
            this.productName = productName;
            this.productDescription = productDescription;

            validateConstructor(productName, productDescription);
        }

        private static void validateConstructor(final String productName, final String productDescription) {
            Assert.hasText(productName, "제품 이름은 필수입니다.");
            Assert.hasText(productDescription, "제품 설명은 필수입니다.");
        }
    }

    private class RegisterRepository {
        private final Map<Long, RegisterProduct> registerProducts = new HashMap<>();
        private Long sequence = 1L;

        public void save(final Product product) {

        }
    }
}
