package io.practice.tdd.order;

import io.practice.tdd.product.domain.Product;
import io.practice.tdd.product.infrastructure.ProductRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegisterOrder {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Transactional
    @PostMapping("/orders/{productId}")
    public ResponseEntity<Void> register(@RequestBody @Valid final RegisterOrderRequest request, @PathVariable final Long productId) {

        final Product product = productRepository.getBy(productId);

        final Order order = request.toDomain(product, request.quantity());

        orderRepository.save(order);

        return ResponseEntity.status(HttpStatus.CREATED.value()).build();
    }
}
