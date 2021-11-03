package com.webvarlamov.aoptest.e9;

import com.webvarlamov.aoptest.common.models.GrammyGitarist;
import com.webvarlamov.aoptest.common.models.Signer;
import com.webvarlamov.aoptest.common.models.SimpleAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.stereotype.Component;

@Component
public class RegexpPointcutExample {
    public void start() {
        Signer signer = new GrammyGitarist();
        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        pointcut.setPattern(".*sign.*");
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAdvice());
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(signer);
        proxyFactory.addAdvisor(advisor);

        Signer proxy = (Signer) proxyFactory.getProxy();
        proxy.sign();
    }
}
