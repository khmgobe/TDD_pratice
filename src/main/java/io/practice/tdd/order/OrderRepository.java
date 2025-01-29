package io.practice.tdd.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class OrderRepository {

    private final Map<Long, Order> orderMap = new HashMap<>();
    private Long sequence = 1L;

    public void save(final Order order) {
        order.assignId(sequence++);
        orderMap.put(order.getId(), order);
    }

    public List<Order> findAll() {
        return new ArrayList<>(orderMap.values());
    }
}
