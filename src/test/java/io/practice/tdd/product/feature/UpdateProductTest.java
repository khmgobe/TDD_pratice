package io.practice.tdd.product.feature;

import io.practice.tdd.common.ApiTest;
import io.practice.tdd.common.Scenario;
import io.practice.tdd.product.domain.Product;
import io.practice.tdd.product.infrastructure.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class UpdateProductTest extends ApiTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("상품을 수정한다.")
    void updateProduct()  {

        /**
         * 1. 상품을 등록한다. [O]
         * 2. 등록한 상품을 조회해서 가져온다. [O]
         * 3. 조회해온 상품의 내용을 수정한다. [O]
         * 4. 수정 전과 후의 상품 상태를 확인한다. []
         */
        Scenario.registerProduct().request();

        final Long productId = 1L;
        final String productName = "변경한 상품 이름";
        final String productDescription = "변경한 상품 설명";

        UpdateProduct.UpdateProductRequest request = new UpdateProduct.UpdateProductRequest(productName, productDescription);

        UpdateProduct updateProduct = new UpdateProduct(productRepository);
        updateProduct.update(productId, request);

        final Product product = productRepository.findById(productId).orElseThrow();
        product.toProductResponse(product);

    }

}
