package com.webvarlamov.aoptest.e6;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SimpleStaticPointcutExampleTest {
    @Autowired
    SimpleStaticPointcutExample simpleStaticPointcutExample;

    @Test
    public void start() {
        simpleStaticPointcutExample.start();
    }

}
