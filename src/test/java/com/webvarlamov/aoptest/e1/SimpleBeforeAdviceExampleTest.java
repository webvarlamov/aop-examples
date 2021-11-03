package com.webvarlamov.aoptest.e1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SimpleBeforeAdviceExampleTest {
    @Autowired
    SimpleBeforeAdviceExample simpleBeforeAdviceExample;

    @Test
    public void start() {
        simpleBeforeAdviceExample.start();
    }

}
