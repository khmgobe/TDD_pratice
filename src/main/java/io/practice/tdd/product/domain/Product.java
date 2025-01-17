package io.practice.tdd.product.domain;

import org.springframework.util.Assert;

public class Product {

    private Long productNo;
    private final String productName;
    private final String productDescription;

    public Long getProductNo() {
        return productNo;
    }

    public Product(final String productName,
                   final String productDescription) {

        validateConstructor(productName, productDescription);
        this.productName = productName;
        this.productDescription = productDescription;

    }

    private static void validateConstructor(final String productName, final String productDescription) {
        Assert.hasText(productName, "제품 이름은 필수입니다.");
        Assert.hasText(productDescription, "제품 설명은 필수입니다.");
    }

    public void assignNo(final Long productNo) {
        this.productNo = productNo;
    }
}
