package io.practice.tdd.common;

import io.practice.tdd.common.api.RegisterProductApi;

public class Scenario {
    public static RegisterProductApi registerProduct() {
        return new RegisterProductApi();
    }
}
