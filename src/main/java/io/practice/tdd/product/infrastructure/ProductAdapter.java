package io.practice.tdd.product.infrastructure;

import io.practice.tdd.product.domain.Product;
import io.practice.tdd.product.feature.port.ProductPort;
import org.springframework.stereotype.Component;

@Component
public class ProductAdapter implements ProductPort {

    private final ProductRepository productRepository;

    public ProductAdapter(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProduct(final Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
    }

    @Override
    public void deleteById(final Long productId) {
        productRepository.deleteById(productId);
    }
}
