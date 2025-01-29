package io.practice.tdd.product.dto.request;

import io.practice.tdd.product.domain.Product;
import io.practice.tdd.product.domain.enumeration.DiscountPolicy;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterProductRequest(
        @NotBlank(message = "제품 이름은 필수입니다.")
        String productName,

        @NotBlank(message = "제품 설명은 필수입니다.")
        String productDescription,

        @NotNull(message = "제품의 가격은 필수입니다.")
        Long productPrice,

        @NotNull(message = "제품의 수량은 필수입니다.")
        Integer productQuantity,

        @NotNull(message = "할인 정책은 필수입니다.")
        DiscountPolicy discountPolicy) {

    public Product toDomain() {
        return Product.builder()
                .productName(productName)
                .productDescription(productDescription)
                .productPrice(productPrice)
                .productQuantity(productQuantity)
                .discountPolicy(discountPolicy)
                .build();
    }
}
