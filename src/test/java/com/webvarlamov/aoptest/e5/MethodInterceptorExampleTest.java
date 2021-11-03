package com.webvarlamov.aoptest.e5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MethodInterceptorExampleTest {
    @Autowired
    MethodInterceptorExample methodInterceptorExample;

    @Test
    public void start() {
        methodInterceptorExample.start();
    }
}
