package com.webvarlamov.aoptest.e12;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IsModifiedMixinExampleTest {
    @Autowired
    IsModifiedMixinExample isModifiedMixinExample;

    @Test
    public void start() {
        isModifiedMixinExample.start();
    }
}
