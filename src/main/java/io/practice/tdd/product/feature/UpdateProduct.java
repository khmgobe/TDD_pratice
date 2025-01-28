package io.practice.tdd.product.feature;

import io.practice.tdd.product.domain.Product;
import io.practice.tdd.product.dto.request.UpdateProductRequest;
import io.practice.tdd.product.feature.port.ProductPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class UpdateProduct {
    private final ProductPort productPort;

    @Transactional
    @PatchMapping("/products/{productId}")
    public ResponseEntity<Void> update(@PathVariable final Long productId, @Valid @RequestBody final UpdateProductRequest request) {

        final Product product = productPort.getProduct(productId);

        product.update(
                request.productName(),
                request.productDescription(),
                request.productPrice(),
                request.productQuantity(),
                request.discountPolicy());

        return ResponseEntity.ok().build();
    }
}