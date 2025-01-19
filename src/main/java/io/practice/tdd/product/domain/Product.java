package io.practice.tdd.product.domain;

import io.practice.tdd.product.dto.response.GetProductResponse;
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
@Getter(AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
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

    public void update(final String productName, final String productDescription) {
        this.productName = productName;
        this.productDescription = productDescription;
        Assert.hasText(productName, "상품명은 필수입니다.");
        Assert.hasText(productDescription, "상품명은 필수입니다.");
    }

    public GetProductResponse toProductResponse(final Product product) {
        final GetProductResponse response = new GetProductResponse(product.getProductNo(), product.getProductName(), product.getProductDescription());
        return response;
    }
}
