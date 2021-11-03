package com.webvarlamov.aoptest.e1;

import com.webvarlamov.aoptest.common.models.Gitarist;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.stereotype.Component;

@Component
public class SimpleBeforeAdviceExample {
    public void start() {
        Gitarist johnMayer = new Gitarist();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new SimpleBeforeAdvice());
        proxyFactory.setTarget(johnMayer);

        Gitarist proxy = (Gitarist) proxyFactory.getProxy();
        proxy.sign();
    }
}
