package com.webvarlamov.aoptest.e9;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RegexpPointcutExampleTest {
    @Autowired
    RegexpPointcutExample regexpPointcutExample;

    @Test
    public void start() {
        regexpPointcutExample.start();;
    }
}
