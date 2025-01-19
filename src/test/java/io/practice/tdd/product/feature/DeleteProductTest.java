package io.practice.tdd.product.feature;

import io.practice.tdd.common.Scenario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeleteProductTest {


    /**
     * 1. 상품을 저장한다. [O]
     * 2. 상품을 삭제한다.
     * 3. 정상적으로 삭제되었는지 확인한다.
     */

    @Test
    @DisplayName("상품을 삭제한다.")
    void deleteProduct()  {

        Scenario.registerProduct().request();
    }
}
