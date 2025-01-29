package io.practice.tdd.order.in.web;

import io.practice.tdd.order.application.RegisterOrderService;
import io.practice.tdd.order.in.web.dto.request.RegisterOrderRequest;
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
public class OrderController {

    private final RegisterOrderService registerOrderService;

    @Transactional
    @PostMapping("/orders/{productId}")
    public ResponseEntity<Void> register(
            @PathVariable final Long productId,
            @RequestBody @Valid final RegisterOrderRequest request) {

        registerOrderService.register(productId, request);

        return ResponseEntity.status(HttpStatus.CREATED.value()).build();
    }
}
