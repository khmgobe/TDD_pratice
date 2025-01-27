package io.practice.tdd.product.dto.request;

import lombok.Builder;
import org.springframework.util.Assert;

@Builder
public record UpdateProductRequest(String productName, String productDescription, Long productPrice) {

    public UpdateProductRequest {
        Assert.hasText(productName, "제품명은 필수입니다.");
        Assert.hasText(productDescription, "제품명은 필수입니다.");
        Assert.notNull(productPrice,"제품 가격은 필수입니다." );
    }
}
