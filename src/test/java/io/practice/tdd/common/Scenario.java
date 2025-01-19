package io.practice.tdd.common;

import io.practice.tdd.common.api.DeleteProductApi;
import io.practice.tdd.common.api.RegisterProductApi;
import io.practice.tdd.common.api.UpdateProductApi;

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
}
