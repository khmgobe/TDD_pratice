package io.practice.tdd.order.out.persistence;

import io.practice.tdd.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
