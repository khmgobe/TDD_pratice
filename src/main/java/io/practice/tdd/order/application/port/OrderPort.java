package io.practice.tdd.order.application.port;


import io.practice.tdd.order.domain.Order;
import io.practice.tdd.product.domain.Product;

public interface OrderPort {

    void save(Order order);

    Product getByProduct(Long productId);

    void cancel(Long orderId);
}