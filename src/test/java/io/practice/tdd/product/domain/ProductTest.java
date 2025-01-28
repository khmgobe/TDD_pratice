package io.practice.tdd.product.domain;

import io.practice.tdd.product.domain.enumeration.DiscountPolicy;
import io.practice.tdd.product.util.ProductSteps;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductTest {


    @Test
    @DisplayName("상품을 수정하고 수정한 결과를 확인한다.")
    void updateProduct()  {

        final Product product = ProductSteps.productBuilder();

        product.update("names", "eee", 10000L, 100, DiscountPolicy.FIXED_1000_AMOUNT);

        Assertions.assertThat(product.getProductName()).isEqualTo("names");
    }

    @Test
    @DisplayName("상품을 수정 할 때, 가격이 1원 이하이면 안 된다.")
    void updateProductLessThenOnePrice()  {

        final Product product = ProductSteps.productBuilder();


        Assertions.assertThatThrownBy(() ->
                product.update(
                        "names",
                        "description",
                        0L,
                        100,
                        DiscountPolicy.FIXED_1000_AMOUNT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("제품의 가격은 1원 이상이어야 합니다.");
    }

    @Test
    @DisplayName("상품을 수정 할 때, 수량이 1 이하이면 안 된다.")
    void updateProductLessThenOneQuantity()  {

        final Product product = ProductSteps.productBuilder();

        Assertions.assertThatThrownBy(() ->
                        product.update(
                                "names",
                                "ddd",
                                5000L,
                                0,
                                DiscountPolicy.FIXED_1000_AMOUNT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("제품의 수량은 1개 이상이어야 합니다.");

    }
}
