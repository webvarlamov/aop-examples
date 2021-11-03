package com.webvarlamov.aoptest.e7;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        System.out.println("Dynamic check for '" + method.getName() + "' method");
        int x = ((Integer) args[0]).intValue();
        return (x == 100);
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        System.out.println("Static check for '" + method.getName() + "' method");
        return "foo".equals(method.getName());
    }

    @Override
    public ClassFilter getClassFilter() {
        return clazz -> clazz == SampleBean.class;
    }
}
