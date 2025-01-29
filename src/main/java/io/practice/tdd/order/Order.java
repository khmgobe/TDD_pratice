package io.practice.tdd.order;

import io.practice.tdd.product.domain.Product;
import org.springframework.util.Assert;

class Order {

    Long id;
    final Product product;
    final int quantity;

    public Order(
            final Product product,
            final int quantity) {

        this.product = product;
        this.quantity = quantity;

        validateConstructor(product, quantity);
    }

    private void validateConstructor(
            final Product product,
            final int quantity) {

        Assert.notNull(product, "상품은 필수입니다.");
        Assert.notNull(quantity, "수량은 필수입니다.");
    }

    public void assignId(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
