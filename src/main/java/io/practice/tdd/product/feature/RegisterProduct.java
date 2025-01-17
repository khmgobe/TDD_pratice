package io.practice.tdd.product.feature;

import io.practice.tdd.product.dto.request.RegisterProductRequest;
import io.practice.tdd.product.infrastructure.ProductRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegisterProduct {

    private final ProductRepository productRepository;

    @Transactional
    @PostMapping("/products")
    public ResponseEntity<Void> request(@RequestBody @Valid final RegisterProductRequest request) {
        productRepository.save(request.toDomain());

        return ResponseEntity.status(HttpStatus.CREATED.value()).build();
    }

}
