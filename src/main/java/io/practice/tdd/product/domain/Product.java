package io.practice.tdd.product.domain;

import io.practice.tdd.product.dto.response.GetProductResponse;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Comment("제품 테이블")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_no", nullable = false)
    private Long productNo;

    @Comment("제품 이름")
    @Column(name = "product_name", nullable = false)
    private String productName;

    @Comment("제품 설명")
    @Column(name = "product_description", nullable = false)
    private String productDescription;

    @Comment("제품 가격")
    @Column(name = "product_price", nullable = false)
    private Long productPrice;

    @Comment("제품 할인율")
    @Column(name = "product_discount")
    private Integer productDiscount;

    @CreatedDate
    @Comment("제품 생성시간")
    @Column(name = "create_at", nullable = false)
    private LocalDateTime createAt;

    @LastModifiedDate
    @Comment("제품 수정시간")
    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateAt;

    @Builder
    private Product(final String productName,
                    final String productDescription,
                    final Long productPrice) {

        validateConstructor(productName, productDescription, productPrice);
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;

    }

    private void validateConstructor(final String productName, final String productDescription, final Long productPrice) {
        Assert.hasText(productName, "제품 이름은 필수입니다.");
        Assert.hasText(productDescription, "제품 설명은 필수입니다.");
        Assert.notNull(productPrice, "제품의 가격은 필수입니다.");

        validateProductPrice(productPrice);

    }

    private static void validateProductPrice(final Long productPrice) {
        if (0 > productPrice) {
            throw new IllegalArgumentException("제품의 가격은 1원 이상이어야 합니다.");
        }
    }

    public void update(final String productName, final String productDescription, final Long productPrice) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        Assert.hasText(productName, "제품명은 필수입니다.");
        Assert.hasText(productDescription, "제품명은 필수입니다.");
        Assert.notNull(productPrice, "제품 가격");
    }

    public GetProductResponse toProductResponse(final Product product) {

        final GetProductResponse response = new GetProductResponse(
                product.getProductNo(),
                product.getProductName(),
                product.getProductDescription(),
                product.getProductPrice(),
                product.getCreateAt(),
                product.getUpdateAt());

        return response;
    }
}
