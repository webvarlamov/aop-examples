package com.webvarlamov.aoptest.common.models;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SimpleAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println(">> Invoking '" + invocation.getMethod() + "'");
        Object proceed = invocation.proceed();
        System.out.println(">> Done!");
        return proceed;
    }
}
