package io.practice.tdd.product.feature;

import io.practice.tdd.common.ApiTest;
import io.practice.tdd.common.Scenario;
import io.practice.tdd.product.feature.port.ProductPort;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

class DeleteProductTest extends ApiTest {

    @Autowired
    private ProductPort productPort;

    @Test
    @DisplayName("상품을 삭제한다.")
    void deleteProduct()  {

        final ExtractableResponse<Response> response = Scenario.deleteProduct().request();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }
}
