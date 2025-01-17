package io.practice.tdd.product.feature;

import io.practice.tdd.common.ApiTest;
import io.practice.tdd.common.Scenario;
import io.practice.tdd.product.infrastructure.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class RegisterProductTest extends ApiTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("프로덕트를 등록한다")
    void registerProduct() {

        Scenario.registerProduct().request();

        assertThat(productRepository.findAll()).hasSize(1);
    }
}