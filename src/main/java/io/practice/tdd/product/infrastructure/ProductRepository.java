package io.practice.tdd.product.infrastructure;

import io.practice.tdd.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    default Product getBy(final Long productId) {
        return findById(productId).orElseThrow(()
                -> new IllegalArgumentException("%번 상품이 존재하지 않습니다" +  productId));
    }
}
