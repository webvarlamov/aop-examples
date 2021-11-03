package com.webvarlamov.aoptest.e6;

import com.webvarlamov.aoptest.common.models.GoodGitarist;
import com.webvarlamov.aoptest.common.models.GreatGitarist;
import com.webvarlamov.aoptest.common.models.Signer;
import com.webvarlamov.aoptest.common.models.SimpleAdvice;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.stereotype.Component;

@Component
public class SimpleStaticPointcutExample {
    public void start() {
        GoodGitarist goodGitarist = new GoodGitarist();
        GreatGitarist greatGitarist = new GreatGitarist();

        Signer proxyOne;
        Signer proxyTwo;

        Pointcut pc = new SimpleStaticPointcut();
        Advice advice = new SimpleAdvice();

        Advisor advisor = new DefaultPointcutAdvisor(pc, advice);

        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(goodGitarist);
        proxyOne = (Signer) proxyFactory.getProxy();

        proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(greatGitarist);
        proxyTwo = (Signer) proxyFactory.getProxy();

        proxyOne.sign();
        proxyTwo.sign();
    }
}
