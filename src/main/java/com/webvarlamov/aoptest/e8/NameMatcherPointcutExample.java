package com.webvarlamov.aoptest.e8;

import com.webvarlamov.aoptest.common.models.GrammyGitarist;
import com.webvarlamov.aoptest.common.models.Signer;
import com.webvarlamov.aoptest.common.models.SimpleAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.stereotype.Component;

@Component
public class NameMatcherPointcutExample {
    public void start() {
        GrammyGitarist grammyGitarist = new GrammyGitarist();
        NameMatchMethodPointcut nameMatchMethodPointcut = new NameMatchMethodPointcut();
        nameMatchMethodPointcut.addMethodName("sign");
        nameMatchMethodPointcut.addMethodName("rest");

        Advisor advisor = new DefaultPointcutAdvisor(nameMatchMethodPointcut, new SimpleAdvice());

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(grammyGitarist);

        Signer proxy = (Signer) proxyFactory.getProxy();
        proxy.sign();
    }
}
