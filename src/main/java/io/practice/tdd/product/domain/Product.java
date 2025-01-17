package io.practice.tdd.product.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.util.Assert;

@Entity
@Table(name = "products")
@Comment("프로덕트 테이블")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @Getter(AccessLevel.PROTECTED)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_no", nullable = false)
    private Long productNo;
    @Column(name = "product_name", nullable = false)
    @Comment("제품 이름")
    private String productName;
    @Comment("제품 설명")
    @Column(name = "product_description", nullable = false)
    private String productDescription;

    @Builder
    private Product(final String productName,
                    final String productDescription) {

        validateConstructor(productName, productDescription);
        this.productName = productName;
        this.productDescription = productDescription;

    }

    private void validateConstructor(final String productName, final String productDescription) {
        Assert.hasText(productName, "제품 이름은 필수입니다.");
        Assert.hasText(productDescription, "제품 설명은 필수입니다.");
    }
}
