package io.practice.tdd.order.domain;

import io.practice.tdd.order.domain.enumeration.OrderStatus;
import io.practice.tdd.product.domain.Product;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
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

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Builder
    private Order(
            final Product product,
            final int quantity,
            final OrderStatus orderStatus) {

        this.product = product;
        this.quantity = quantity;
        this.orderStatus = orderStatus;


        validateConstructor(product, quantity, orderStatus);

    }

    private void validateConstructor(
            final Product product,
            final int quantity,
            final OrderStatus orderStatus) {

        Assert.notNull(product, "상품은 필수입니다.");
        Assert.notNull(quantity, "수량은 필수입니다.");
        Assert.notNull(orderStatus, "주문 상태는 필수입니다.");
    }
}
