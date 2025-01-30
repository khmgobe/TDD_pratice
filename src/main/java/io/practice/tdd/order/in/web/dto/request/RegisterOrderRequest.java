package io.practice.tdd.order.in.web.dto.request;

import io.practice.tdd.order.domain.Order;
import io.practice.tdd.order.domain.enumeration.OrderStatus;
import io.practice.tdd.product.domain.Product;
import lombok.Builder;
import org.springframework.util.Assert;

@Builder
public record RegisterOrderRequest(
        Integer quantity,
        OrderStatus orderStatus) {

    public RegisterOrderRequest {
        Assert.notNull(quantity, "수량은 필수입니다.");
        Assert.notNull(orderStatus, "주문 상태는 필수입니다.");
    }

    public Order toDomain(Product product) {

        return Order
                .builder()
                .product(product)
                .quantity(quantity)
                .orderStatus(orderStatus)
                .build();
    }
}
