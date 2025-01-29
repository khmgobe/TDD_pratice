package io.practice.tdd.order.domain;

import io.practice.tdd.product.domain.Product;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@Entity
@Getter
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Product product;

    private int quantity;

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
}
