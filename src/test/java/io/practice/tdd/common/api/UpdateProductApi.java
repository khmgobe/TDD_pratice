package io.practice.tdd.common.api;

import io.practice.tdd.common.Scenario;
import io.practice.tdd.product.dto.request.UpdateProductRequest;

public class UpdateProductApi {

    public Scenario request() {

        final String productName = "변경한 상품 이름";
        final String productDescription = "변경한 상품 설명";

        UpdateProductRequest request = new UpdateProductRequest(productName, productDescription);
        return new Scenario();
    }
}
