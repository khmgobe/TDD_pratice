package io.practice.tdd.product.feature;

import io.practice.tdd.common.ApiTest;
import io.practice.tdd.common.Scenario;
import io.practice.tdd.product.feature.port.ProductPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DeleteProductTest extends ApiTest {


    @Autowired
    private ProductPort productPort;

    /**
     * 1. 상품을 저장한다. [O]
     * 2. 상품을 삭제한다. [O]
     * 3. 정상적으로 삭제되었는지 확인한다. [O]
     */

    @Test
    @DisplayName("상품을 삭제한다.")
    void deleteProduct()  {

        // given
        final Long productId = 1L;
        Scenario.registerProduct().request();

        // when
        productPort.deleteById(productId);

        // then
        assertThatThrownBy(() -> productPort.getProduct(productId))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("상품이 존재하지 않습니다.");
    }
}
