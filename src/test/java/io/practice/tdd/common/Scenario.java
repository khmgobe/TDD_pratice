package io.practice.tdd.common;

import io.practice.tdd.common.api.*;

public class Scenario {

    public static RegisterProductApi registerProduct() {
        return new RegisterProductApi();
    }

    public static UpdateProductApi updateProduct() {
        return new UpdateProductApi();
    }

    public static DeleteProductApi deleteProduct() {
        return new DeleteProductApi();
    }

    public static RegisterOrderApi registerOrder() {
        return new RegisterOrderApi();
    }
    public static CancelOrderApi cancelOrder() {
        return new CancelOrderApi();
    }
}
