package io.practice.tdd.order.domain.enumeration;

public enum OrderStatus {

    FAILED("주문 실패"),
    CANCEL("주문 취소"),
    SUCCESS("주문 성공");

    private final String description;

    OrderStatus(final String description) {
        this.description = description;
    }
}
