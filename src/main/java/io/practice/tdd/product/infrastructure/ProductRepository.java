package io.practice.tdd.product.infrastructure;

import io.practice.tdd.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
