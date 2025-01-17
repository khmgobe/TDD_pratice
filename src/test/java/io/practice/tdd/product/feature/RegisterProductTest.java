package io.practice.tdd.product.feature;

import io.practice.tdd.common.ApiTest;
import io.practice.tdd.product.domain.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RegisterProductTest extends ApiTest {


    private ProductRepository productRepository;

    private RegisterProduct registerProduct;

    @BeforeEach
    void setUp() {
        productRepository = new ProductRepository();
        registerProduct = new RegisterProduct(productRepository);
    }

    @Test
    @DisplayName("프로덕트를 등록한다")
    void registerProduct() {
        final String productName = "productName";
        final String productDescription = "productDescription";

        RegisterProduct.Request request = new RegisterProduct.Request(productName, productDescription);

        registerProduct.request(request);

        assertThat(productRepository.findAll()).hasSize(1);
    }
}