package com.webvarlamov.aoptest.e12;

import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.stereotype.Component;

@Component
public class IsModifiedMixinExample {
    public void start() {
        Contact contact = new Contact();
        contact.setName("Roman");

        IntroductionAdvisor advisor = new IsModifiedAdvisor();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(contact);
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setOptimize(true);

        Contact proxy = (Contact) proxyFactory.getProxy();
        IsModified proxyInterface = (IsModified) proxy;

        System.out.println("Is Contact?: " + (proxy instanceof Contact));
        System.out.println("Is IsModified?: " + (proxy instanceof IsModified));
        System.out.println("Has been modified?: " + proxyInterface.isModified());

        proxy.setName("Oleg");

        System.out.println("Has been modified?: " + proxyInterface.isModified());

        proxy.setName("Eric");

        System.out.println("Has been modified?: " + proxyInterface.isModified());
    }
}
