package io.practice.tdd.product.feature;

import io.practice.tdd.common.ApiTest;
import io.practice.tdd.common.Scenario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

class UpdateProductTest extends ApiTest {

    @Test
    @DisplayName("상품을 수정한다.")
    void updateProduct()  {

        /**
         * 1. 상품을 등록한다. [O]
         * 2. 등록한 상품을 조회해서 가져온다. []
         * 3. 조회해온 상품의 내용을 수정한다. []
         * 4. 수정 전과 후의 상품 상태를 확인한다. []
         */
        Scenario.registerProduct().request();

        final Long productId = 1L;
        final String productName = "변경한 상품 이름";
        final String productDescription = "변경한 상품 설명";

        UpdateProductRequest request = new UpdateProductRequest(productName, productDescription);

        UpdateProduct updateProduct = new UpdateProduct();
        updateProduct.update(productId, request);

    }

    private record UpdateProductRequest(String productName, String productDescription) {

        UpdateProductRequest{
            Assert.hasText(productName, "상품명은 필수입니다.");
            Assert.hasText(productDescription, "상품명은 필수입니다.");
        }
    }

    private class UpdateProduct {
        public void update(final Long productId, final UpdateProductRequest request) {

        }
    }
}
