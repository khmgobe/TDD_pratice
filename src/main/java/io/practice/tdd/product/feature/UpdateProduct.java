package io.practice.tdd.product.feature;

import io.practice.tdd.product.domain.Product;
import io.practice.tdd.product.infrastructure.ProductRepository;
import org.springframework.util.Assert;

class UpdateProduct {
    private final ProductRepository productRepository;

    UpdateProduct(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    record UpdateProductRequest(String productName, String productDescription) {

        UpdateProductRequest {
            Assert.hasText(productName, "상품명은 필수입니다.");
            Assert.hasText(productDescription, "상품명은 필수입니다.");
        }
    }

    public void update(final Long productId, final UpdateProductRequest request) {
        final Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
        product.update(request.productName, request.productDescription);
    }
}
