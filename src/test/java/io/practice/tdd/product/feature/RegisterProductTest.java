package io.practice.tdd.product.feature;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RegisterProductTest {



    @Test
    @DisplayName("프로덕트를 등록한다")
    void registerProduct()  {
        RegisterProduct registerProduct = new RegisterProduct();
    }

    private class RegisterProduct {
    }
}
