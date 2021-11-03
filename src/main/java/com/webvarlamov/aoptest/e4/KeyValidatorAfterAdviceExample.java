package com.webvarlamov.aoptest.e4;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.stereotype.Component;

@Component
public class KeyValidatorAfterAdviceExample {
    public void start() {
        KeyGenerator keyGenerator = getKeyGenerator();
        keyGenerator.getKey();
    }

    public KeyGenerator getKeyGenerator() {
        KeyGenerator target = new KeyGenerator();
        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(new KeyCheckAdvice());

        return  (KeyGenerator) proxyFactory.getProxy();
    }
}
