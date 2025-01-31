package io.practice.tdd.order.feature;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CancelOrderTest {

    private CancelOrderService cancelOrderService;
    private FakeOrderRepository fakeOrderRepository;

    @BeforeEach
    void setUp() {
        fakeOrderRepository = new FakeOrderRepository();
        cancelOrderService = new CancelOrderService(fakeOrderRepository);
    }

    @Test
    @DisplayName("주문을 등록하고 등록한 주문을 취소한다.")
    void cancelOrder() {

        final Long orderId = 1L;
        final String orderName = "orderName";
        final String orderDescription = "orderDescription";

        FakeOrderRequest fakeOrderRequest = new FakeOrderRequest(orderName, orderDescription);

        cancelOrderService.registerOrder(fakeOrderRequest);

        Assertions.assertThat(fakeOrderRepository.findAll()).hasSize(1);
    }

    private class CancelOrderService {

        private final FakeOrderRepository fakeOrderRepository;

        public CancelOrderService(final FakeOrderRepository fakeOrderRepository) {
            this.fakeOrderRepository = fakeOrderRepository;
        }

        public void registerOrder(FakeOrderRequest fakeOrderRequest) {
            final FakeOrder domain = fakeOrderRequest.toDomain();
            fakeOrderRepository.save(domain);
        }

        public void cancelOrder() {
        }
    }

    private class FakeOrderRepository {

        private Map<Long, FakeOrder> fakeOrderMap = new HashMap<>();
        private Long sequence = 1L;

        public void save(final FakeOrder fakeOrder) {
            fakeOrder.assignId(sequence++);
            fakeOrderMap.put(fakeOrder.getId(), fakeOrder);
        }

        public List<FakeOrder> findAll() {
            return new ArrayList<>(fakeOrderMap.values());
        }
    }

    private static class FakeOrder {

        private Long id;
        private final String orderName;
        private final String orderDescription;

        public FakeOrder( final String orderName, final String orderDescription) {
            this.orderName = orderName;
            this.orderDescription = orderDescription;
        }

        public void assignId(final Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }
    }

    private record FakeOrderRequest(
            String orderName,
            String orderDescription) {

        public FakeOrderRequest {
            Assert.notNull(orderName, "주문 이름은 필수입니다.");
            Assert.notNull(orderDescription, "주문 정보는 필수입니다.");
        }

        public FakeOrder toDomain() {
            return new FakeOrder(orderName, orderDescription);
        }
    }
}
