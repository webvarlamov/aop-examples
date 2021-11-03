package com.webvarlamov.aoptest.e3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SimpleAfterReturnAdviceExampleTest {
    @Autowired
    SimpleAfterReturnAdviceExample simpleAfterReturnAdviceExample;

    @Test
    public void start() {
        simpleAfterReturnAdviceExample.start();
    }

}
