package com.webvarlamov.aoptest.e10;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AspectJExpressionPointcutExampleTest {
    @Autowired
    AspectJExpressionPointcutExample aspectJExpressionPointcutExample;

    @Test
    public void start() {
        aspectJExpressionPointcutExample.start();
    }

}
