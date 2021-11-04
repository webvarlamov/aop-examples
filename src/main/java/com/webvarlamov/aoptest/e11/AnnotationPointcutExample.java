package com.webvarlamov.aoptest.e11;

import com.webvarlamov.aoptest.common.models.Signer;
import com.webvarlamov.aoptest.common.models.SimpleAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.stereotype.Component;

@Component
public class AnnotationPointcutExample {
    public void start() {
        Signer signer = new AnnotatedGuitarist();
        AnnotationMatchingPointcut pointcut = AnnotationMatchingPointcut.forMethodAnnotation(AdviseRequired.class);
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAdvice());

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(signer);
        proxyFactory.addAdvisor(advisor);

        Signer proxy = (Signer) proxyFactory.getProxy();
        proxy.sign();
    }
}
