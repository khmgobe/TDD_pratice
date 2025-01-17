package io.practice.tdd.product.domain;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {

    private final Map<Long, Product> registerProducts = new HashMap<>();
    private Long sequence = 1L;

    public void save(final Product product) {
        product.assignNo(sequence++);
        registerProducts.put(product.getProductNo(), product);
    }
}
