package com.webvarlamov.aoptest.e5;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

public class ProfilingInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(invocation.getMethod().getName());
        Object proceed = invocation.proceed();
        stopWatch.stop();
        dumpInfo(invocation, stopWatch.getTotalTimeMillis());
        return proceed;
    }

    private void dumpInfo(MethodInvocation invocation, long ms) {
        Method method = invocation.getMethod();
        Object target = invocation.getThis();
        Object args = invocation.getArguments();

        System.out.println("Executed method: " + method.getName());
        System.out.println("On object of type:  " + target.getClass().getName());
        System.out.println("With args: ");
        System.out.println(args);
        System.out.println("Took: " + ms + " ms");
    }
}
