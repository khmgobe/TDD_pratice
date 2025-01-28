package io.practice.tdd.product.dto.request;

import io.practice.tdd.product.domain.enumeration.DiscountPolicy;
import lombok.Builder;
import org.springframework.util.Assert;

@Builder
public record UpdateProductRequest(String productName, String productDescription, Long productPrice, Integer productQuantity, DiscountPolicy discountPolicy) {

    public UpdateProductRequest {

        Assert.hasText(productName, "제품 이름은 필수입니다.");
        Assert.hasText(productDescription, "제품 설명은 필수입니다.");
        Assert.notNull(productPrice, "제품의 가격은 필수입니다.");
        Assert.notNull(productQuantity, "제품 수량은 필수입니다.");
        Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");

    }
}
