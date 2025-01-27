package io.practice.tdd.product.util;

import io.practice.tdd.product.dto.request.UpdateProductRequest;

public class ProductSteps {

    public static UpdateProductRequest updateRequest() {

        final String productName = "변경한 상품 이름";
        final String productDescription = "변경한 상품 설명";
        final Long productPrice = 50000L;

        final UpdateProductRequest updateProductRequest = UpdateProductRequest
                .builder()
                .productName(productName)
                .productDescription(productDescription)
                .productPrice(productPrice)
                .build();

        return updateProductRequest;
    }
}
