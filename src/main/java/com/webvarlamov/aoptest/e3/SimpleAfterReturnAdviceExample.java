package com.webvarlamov.aoptest.e3;

import com.webvarlamov.aoptest.common.models.Gitarist;
import com.webvarlamov.aoptest.common.models.Signer;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.stereotype.Component;

@Component
public class SimpleAfterReturnAdviceExample {
    public void start() {
        Signer target = new Gitarist();
        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.addAdvice(new SimpleAfterReturningAdvice());
        proxyFactory.setTarget(target);

        Signer proxy = (Signer) proxyFactory.getProxy();
        proxy.sign();
    }
}
