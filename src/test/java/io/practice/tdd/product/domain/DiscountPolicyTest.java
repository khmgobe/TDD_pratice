package io.practice.tdd.product.domain;

import io.practice.tdd.product.domain.enumeration.DiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountPolicyTest {

    @Test
    @DisplayName("금액을 할인하지 않는다.")
    void noneDiscountPolicy()  {

        Long price = 10000L;

        final Long afterPrice = DiscountPolicy.NONE.apply(price);

        assertThat(price).isEqualTo(afterPrice);
    }


    @Test
    @DisplayName("고정된 금액을 할인한다.")
    void fixDiscountPolicy()  {

        final Long price = 2000L;
        final Long changedPrice = DiscountPolicy.FIXED_1000_AMOUNT.apply(price);

        assertThat(changedPrice).isEqualTo(1000L);
    }
}