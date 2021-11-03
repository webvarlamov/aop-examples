package com.webvarlamov.aoptest.e8;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NameMatcherPointcutExampleTest {
    @Autowired
    NameMatcherPointcutExample nameMatcherPointcutExample;
    @Test
    public void start() {
        nameMatcherPointcutExample.start();
    }
}
