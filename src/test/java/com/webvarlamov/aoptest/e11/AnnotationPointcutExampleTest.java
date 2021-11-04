package com.webvarlamov.aoptest.e11;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AnnotationPointcutExampleTest {
    @Autowired
    AnnotationPointcutExample annotationPointcutExample;

    @Test
    void start() {
        annotationPointcutExample.start();
    }
}
