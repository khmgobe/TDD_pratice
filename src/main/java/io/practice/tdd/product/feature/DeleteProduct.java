package io.practice.tdd.product.feature;


import io.practice.tdd.product.feature.port.ProductPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class DeleteProduct {

    private final ProductPort productPort;

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        productPort.deleteById(productId);
        return ResponseEntity.ok().build();
    }
}
