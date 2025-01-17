package io.practice.tdd.product.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductRepository {

    private final Map<Long, Product> registerProducts = new HashMap<>();
    private Long sequence = 1L;

    public void save(final Product product) {
        product.assignNo(sequence++);
        registerProducts.put(product.getProductNo(), product);
    }

    public List<Product> findAll() {
        return new ArrayList<>(registerProducts.values());
    }
}
