package io.practice.tdd.product.feature.port;

import io.practice.tdd.product.domain.Product;

public interface ProductPort  {

    Product getProduct(Long productId);
}
