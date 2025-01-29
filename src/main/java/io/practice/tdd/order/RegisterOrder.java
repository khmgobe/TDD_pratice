package io.practice.tdd.order;

class RegisterOrder {

    private final OrderRepository orderRepository;

    RegisterOrder(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void register(final RegisterOrderRequest request) {
        final Order order = request.toDomain();
        orderRepository.save(order);
    }
}
