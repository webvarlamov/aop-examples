package com.webvarlamov.aoptest.e7;

import com.webvarlamov.aoptest.common.models.SimpleAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.stereotype.Component;

@Component
public class SimpleDynamicPointcutExample {
    public void start() {
        SampleBean sampleBean = new SampleBean();
        Advisor advisor = new DefaultPointcutAdvisor(new SimpleDynamicPointcut(), new SimpleAdvice());

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(sampleBean);
        proxyFactory.addAdvisor(advisor);

        SampleBean proxy = (SampleBean) proxyFactory.getProxy();

        proxy.foo(1);
        proxy.foo(100);
        proxy.foo(10000);

        proxy.bar();
        proxy.bar();
        proxy.bar();
    }
}
