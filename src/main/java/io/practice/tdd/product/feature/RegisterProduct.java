package io.practice.tdd.product.feature;

import io.practice.tdd.product.domain.Product;
import io.practice.tdd.product.domain.ProductRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegisterProduct {

    private final ProductRepository productRepository;

    @Transactional
    @PostMapping("/products")
    public ResponseEntity<Void> request(@RequestBody @Valid final Request request) {
        productRepository.save(request.toDomain());

        return ResponseEntity.status(HttpStatus.CREATED.value()).build();
    }

    public record Request(
            @NotBlank(message = "상품 이름은 필수입니다.")
            String productName,
            @NotBlank(message = "상품 설명은 필수입니다.")
            String productDescription) {
        public Request {
            Assert.hasText(productName, "제품 이름은 필수입니다.");
            Assert.hasText(productDescription, "제품 설명은 필수입니다.");
        }

        public Product toDomain() {
            return Product.builder()
                    .productName(productName)
                    .productDescription(productDescription)
                    .build();
        }
    }
}
