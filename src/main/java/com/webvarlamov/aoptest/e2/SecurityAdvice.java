package com.webvarlamov.aoptest.e2;

import com.webvarlamov.aoptest.common.models.SecurityException;
import lombok.Setter;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

@Setter
public class SecurityAdvice implements MethodBeforeAdvice {
    SecurityManager securityManager;

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        UserInfo userInfo = securityManager.getLoggedOnUser();

        if (userInfo == null) {
            System.out.println("No user authenticated! Before '" + method.getName() + "'");
            throw new SecurityException();
        } else if ("Roman".equals(userInfo.getUsername())) {
            System.out.println("Logged in is Ok!");
        } else {
            System.out.println("Logged in user '" + userInfo.getUsername() + "' has no access!");
            throw new SecurityException();
        }
    }
}
