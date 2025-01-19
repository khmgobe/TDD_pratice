package io.practice.tdd.product.feature;

import io.practice.tdd.product.domain.Product;
import io.practice.tdd.product.dto.request.UpdateProductRequest;
import io.practice.tdd.product.infrastructure.ProductRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class UpdateProduct {
    private final ProductRepository productRepository;

    public void update(@PathVariable final Long productId, @Valid @RequestBody final UpdateProductRequest request) {

        final Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
        product.update(request.productName(), request.productDescription());
        productRepository.save(product);
    }
}
