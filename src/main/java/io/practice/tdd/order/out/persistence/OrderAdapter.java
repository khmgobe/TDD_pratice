package io.practice.tdd.order.out.persistence;

import io.practice.tdd.order.application.port.OrderPort;
import io.practice.tdd.order.domain.Order;
import io.practice.tdd.product.domain.Product;
import io.practice.tdd.product.infrastructure.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderAdapter implements OrderPort {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Override
    public Product getByProduct(final Long productId) {
        return productRepository.getBy(productId);
    }

    @Override
    public void save(final Order order) {
        orderRepository.save(order);
    }
}
