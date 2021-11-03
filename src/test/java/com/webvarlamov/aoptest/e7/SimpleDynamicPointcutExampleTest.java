package com.webvarlamov.aoptest.e7;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SimpleDynamicPointcutExampleTest {
    @Autowired
    SimpleDynamicPointcutExample simpleDynamicPointcutExample;

    @Test
    public void start() {
        simpleDynamicPointcutExample.start();
    }
}
