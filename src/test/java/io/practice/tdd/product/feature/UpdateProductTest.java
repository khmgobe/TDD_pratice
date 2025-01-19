package io.practice.tdd.product.feature;

import io.practice.tdd.common.ApiTest;
import io.practice.tdd.common.Scenario;
import io.practice.tdd.product.domain.Product;
import io.practice.tdd.product.dto.response.GetProductResponse;
import io.practice.tdd.product.infrastructure.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class UpdateProductTest extends ApiTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("상품을 수정한다.")
    void updateProduct()  {

        Scenario.registerProduct().request();

        Scenario.updateProduct().request();

        final Long productId = 1L;

        UpdateProduct updateProduct = new UpdateProduct(productRepository);

        final Product product = productRepository.findById(productId).orElseThrow();

        final GetProductResponse response = product.toProductResponse(product);

        assertThat(response.productName()).isEqualTo("변경한 상품 이름");
        assertThat(response.productDescription()).isEqualTo("변경한 상품 설명");

    }
}
