package io.practice.tdd.product.feature;

import io.practice.tdd.product.domain.Product;
import io.practice.tdd.product.dto.request.UpdateProductRequest;
import io.practice.tdd.product.infrastructure.ProductRepository;

class UpdateProduct {
    private final ProductRepository productRepository;

    UpdateProduct(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void update(final Long productId, final UpdateProductRequest request) {
        final Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
        product.update(request.productName(), request.productDescription());
        productRepository.save(product);
    }
}
