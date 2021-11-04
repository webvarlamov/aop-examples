package com.webvarlamov.aoptest.e10;

import com.webvarlamov.aoptest.common.models.GoodGitarist;
import com.webvarlamov.aoptest.common.models.Signer;
import com.webvarlamov.aoptest.common.models.SimpleAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.stereotype.Component;

@Component
public class AspectJExpressionPointcutExample {
    public void start() {
        Signer signer = new GoodGitarist();
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* sign*(..))");
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAdvice());

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(signer);
        proxyFactory.addAdvisor(advisor);

        Signer proxy = (Signer) proxyFactory.getProxy();
        proxy.sign();
    }
}
