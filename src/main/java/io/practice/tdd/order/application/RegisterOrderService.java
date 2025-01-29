package io.practice.tdd.order.application;

import io.practice.tdd.order.application.port.OrderPort;
import io.practice.tdd.order.domain.Order;
import io.practice.tdd.order.in.web.dto.request.RegisterOrderRequest;
import io.practice.tdd.product.domain.Product;
import io.practice.tdd.product.feature.port.ProductPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterOrderService {

    private final OrderPort orderPort;
    private final ProductPort productPort;

    @Transactional
    public void register(final Long productId, final RegisterOrderRequest request) {

        final Product product = productPort.getProduct(productId);

        final Order order = request.toDomain(product, request.quantity());

        orderPort.save(order);
    }
}
