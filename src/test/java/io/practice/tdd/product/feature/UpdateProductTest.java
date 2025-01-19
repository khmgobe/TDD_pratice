package io.practice.tdd.product.feature;

import io.practice.tdd.common.ApiTest;
import io.practice.tdd.common.Scenario;
import io.practice.tdd.product.domain.Product;
import io.practice.tdd.product.feature.port.ProductPort;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

class UpdateProductTest extends ApiTest {

    @Autowired
    private ProductPort productPort;

    @Test
    @DisplayName("상품을 수정한다.")
    void updateProduct()  {

        final Long productId = 1L;

        final ExtractableResponse<Response> response = Scenario.updateProduct().request();

        final Product product = productPort.getProduct(productId);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(productPort.getProduct(productId).getProductDescription()).isEqualTo("변경한 상품 설명");
    }
}
