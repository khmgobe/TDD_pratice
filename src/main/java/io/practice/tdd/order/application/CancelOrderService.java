package io.practice.tdd.order.application;

import io.practice.tdd.order.out.persistence.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CancelOrderService {

    private final OrderRepository orderRepository;

    @DeleteMapping("/orders/{orderId}")
    public void cancelOrder(@PathVariable final Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
