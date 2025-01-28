package io.practice.tdd.product.dto.response;

import io.practice.tdd.product.domain.enumeration.DiscountPolicy;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

public record GetProductResponse(
        Long productNo,
        String productName,
        String productDescription,
        Long productPrice,
        Integer productQuantity,
        DiscountPolicy discountPolicy,
        LocalDateTime createAt,
        LocalDateTime updateAt) {

    public GetProductResponse {
        Assert.notNull(productNo, "제품 번호는 필수입니다.");
        Assert.hasText(productName, "제품명은 필수입니다.");
        Assert.hasText(productDescription, "제품 설명은 필수입니다.");
        Assert.notNull(productPrice, "제품 가격은 필수입니다.");
        Assert.notNull(productQuantity,"제품 수량은 필수입니다." );
        Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");
        Assert.notNull(createAt, "제품의 생성 시간은 필수입니다.");
        Assert.notNull(updateAt, "제품의 수정 시간은 필수입니다.");
    }
}
