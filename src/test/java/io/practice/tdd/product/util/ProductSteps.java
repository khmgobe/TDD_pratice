package io.practice.tdd.product.util;

import io.practice.tdd.product.domain.Product;
import io.practice.tdd.product.domain.enumeration.DiscountPolicy;
import io.practice.tdd.product.dto.request.UpdateProductRequest;

public class ProductSteps {

    public static Product productBuilder() {

        final Product productData = Product
                .builder()
                .productName("productNames")
                .productDescription("productDescription")
                .productPrice(50000L)
                .productQuantity(5)
                .discountPolicy(DiscountPolicy.FIXED_1000_AMOUNT)
                .build();

        return productData;
    }

    public static UpdateProductRequest updateRequest() {

        final String productName = "변경한 상품 이름";
        final String productDescription = "변경한 상품 설명";
        final Long productPrice = 50000L;
        final Integer productQuantity = 5;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;

        final UpdateProductRequest updateProductRequest = UpdateProductRequest
                .builder()
                .productName(productName)
                .productDescription(productDescription)
                .productPrice(productPrice)
                .productQuantity(productQuantity)
                .discountPolicy(discountPolicy)
                .build();

        return updateProductRequest;
    }
}
