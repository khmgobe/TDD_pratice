package io.practice.tdd.product.dto.request;

import io.practice.tdd.product.domain.Product;
import jakarta.validation.constraints.NotBlank;
import org.springframework.util.Assert;

public record RegisterProductRequest(
        @NotBlank(message = "상품 이름은 필수입니다.")
        String productName,
        @NotBlank(message = "상품 설명은 필수입니다.")
        String productDescription) {
    public RegisterProductRequest {
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
