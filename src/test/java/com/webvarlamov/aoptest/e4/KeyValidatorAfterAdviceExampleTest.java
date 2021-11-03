package com.webvarlamov.aoptest.e4;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KeyValidatorAfterAdviceExampleTest {
    @Autowired
    KeyValidatorAfterAdviceExample keyValidatorAfterAdviceExample;

    @Test
    public void start() {
        keyValidatorAfterAdviceExample.start();
    }
}
