package com.webvarlamov.aoptest.e5;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.stereotype.Component;

@Component
public class MethodInterceptorExample {
    public void start() {
        WorkerBean target = new WorkerBean();
        ProfilingInterceptor profilingInterceptor = new ProfilingInterceptor();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(profilingInterceptor);

        WorkerBean proxy = (WorkerBean) proxyFactory.getProxy();

        try {
            proxy.doSomeWork(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
