package io.practice.tdd.product.feature;

import io.practice.tdd.common.Scenario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UpdateProductTest {

    @Test
    @DisplayName("상품을 수정한다.")
    void updateProduct()  {

        /**
         * 1. 상품을 등록한다. []
         * 2. 등록한 상품을 조회해서 가져온다. []
         * 3. 조회해온 상품의 내용을 수정한다. []
         * 4. 수정 전과 후의 상품 상태를 확인한다. []
         */
        Scenario.registerProduct().request();

    }
}
