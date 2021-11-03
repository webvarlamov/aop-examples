package com.webvarlamov.aoptest.e4;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

import static com.webvarlamov.aoptest.e4.KeyGenerator.WEAK_KEY;

public class KeyCheckAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        if ((target instanceof KeyGenerator) && ("getKey".equals(method.getName()))) {
            long key = ((Long) returnValue).longValue();
            if (key == WEAK_KEY) {
                throw new SecurityException("Key is weak!");
            } else {
                System.out.println("Not weak key generated '" + returnValue + "'");
            }
        }
    }
}
