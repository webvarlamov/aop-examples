package com.webvarlamov.aoptest.e2;

import com.webvarlamov.aoptest.common.models.SecurityException;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.stereotype.Component;

@Component
public class SecurityBeforeAdviceExample {
    public void start() {
        SecurityManager securityManager = new SecurityManager();
        SecurityAdvice securityAdvice = new SecurityAdvice();
        securityAdvice.setSecurityManager(securityManager);

        SecureBean secureBean = getSecurityBean(securityAdvice);

        securityManager.login("Roman", "123");
        secureBean.writeSecureMessage();
        securityManager.logout();

        try {
            securityManager.login("Eduard", "123");
            secureBean.writeSecureMessage();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            securityManager.logout();
        }

        try {
            secureBean.writeSecureMessage();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            securityManager.logout();
        }
    }

    private SecureBean getSecurityBean(SecurityAdvice securityAdvice) {
        SecureBean secureBean = new SecureBean();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(secureBean);
        proxyFactory.addAdvice(securityAdvice);

        return (SecureBean) proxyFactory.getProxy();
    }
}
