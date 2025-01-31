package io.practice.tdd.order.application;

import io.practice.tdd.order.out.persistence.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@RequiredArgsConstructor
public class CancelOrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public void cancelOrder(@PathVariable final Long orderId) {
        orderRepository.deleteById(orderId);
    }
}