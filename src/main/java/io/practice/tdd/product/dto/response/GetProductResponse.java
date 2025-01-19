package io.practice.tdd.product.dto.response;

import org.springframework.util.Assert;

public record GetProductResponse(Long productNo, String productName, String productDescription) {

    public GetProductResponse {
        Assert.notNull(productNo, "상품 번호는 필수입니다.");
        Assert.hasText(productName, "상품명은 필수입니다.");
        Assert.hasText(productDescription, "상품 설명은 필수입니다.");
    }
}
