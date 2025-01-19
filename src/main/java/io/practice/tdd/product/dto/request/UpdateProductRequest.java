package io.practice.tdd.product.dto.request;

import org.springframework.util.Assert;

public record UpdateProductRequest(String productName, String productDescription) {

    public UpdateProductRequest {
        Assert.hasText(productName, "상품명은 필수입니다.");
        Assert.hasText(productDescription, "상품명은 필수입니다.");
    }
}
