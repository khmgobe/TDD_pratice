package io.practice.tdd.product.domain.enumeration;

public enum DiscountPolicy {

    NONE {
        @Override
        public Long apply(final Long productPrice) {
            return productPrice;
        }
    },

    FIXED_1000_AMOUNT {
        @Override
        public Long apply(final Long productPrice) {
            return Math.max(productPrice - 1000, 0L);
        }
    };

    public abstract Long apply(final Long productPrice);
}
