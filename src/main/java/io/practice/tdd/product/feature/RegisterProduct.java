package io.practice.tdd.product.feature;

import io.practice.tdd.product.domain.Product;
import io.practice.tdd.product.domain.ProductRepository;
import org.springframework.util.Assert;

class RegisterProduct {

    private String productName = "productName";
    private String productDescription = "productDescription";
    private ProductRepository productRepository;

    public RegisterProduct(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void request(final Request request) {
        productRepository.save(request.toDomain());
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
