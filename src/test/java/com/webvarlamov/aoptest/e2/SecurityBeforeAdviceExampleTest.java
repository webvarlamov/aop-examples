package com.webvarlamov.aoptest.e2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecurityBeforeAdviceExampleTest {
    @Autowired
    SecurityBeforeAdviceExample securityBeforeAdviceExample;

    @Test
    public void start() {
        securityBeforeAdviceExample.start();
    }
}
