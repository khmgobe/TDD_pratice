package io.practice.tdd.order.in.web;

import io.practice.tdd.order.application.CancelOrderService;
import io.practice.tdd.order.application.RegisterOrderService;
import io.practice.tdd.order.in.web.dto.request.RegisterOrderRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final RegisterOrderService registerOrderService;

    private final CancelOrderService cancelOrderService;

    @PostMapping("/orders/{productId}")
    public ResponseEntity<Void> register(
            @PathVariable final Long productId,
            @RequestBody @Valid final RegisterOrderRequest request) {

        registerOrderService.register(productId, request);

        return ResponseEntity.status(HttpStatus.CREATED.value()).build();
    }

    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity<Void> cancel(@PathVariable final Long orderId) {

        cancelOrderService.cancelOrder(orderId);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
