package io.practice.tdd.order.in.web.dto.request;

import io.practice.tdd.order.domain.Order;
import io.practice.tdd.product.domain.Product;
import org.springframework.util.Assert;

public record RegisterOrderRequest(
        Integer quantity) {

    public RegisterOrderRequest {
        Assert.notNull(quantity, "수량은 필수입니다.");
    }

    public Order toDomain(Product product, Integer quantity) {
        return new Order(product, quantity);
    }
}
