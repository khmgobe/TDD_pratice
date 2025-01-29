package io.practice.tdd.order;

import io.practice.tdd.product.domain.Product;
import org.springframework.util.Assert;

record RegisterOrderRequest(
        Product product,
        Integer quantity) {

    public RegisterOrderRequest {
        Assert.notNull(product, "상품은 필수입니다.");
        Assert.notNull(quantity, "수량은 필수입니다.");
    }

    public Order toDomain() {
        return new Order(product, quantity);
    }
}
