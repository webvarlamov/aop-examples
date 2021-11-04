package com.webvarlamov.aoptest.e13.controller;

import com.webvarlamov.aoptest.e12.Contact;
import com.webvarlamov.aoptest.e13.annotation.EnableResponseWrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableResponseWrapper(wrapperClass = Contact.class)
public class ControllerExample {
    @RequestMapping(path = "/contact", method = RequestMethod.GET)
    public Contact get() {
        Contact contact = new Contact();
        contact.setName("Roman");
        contact.setEmail("web.varlamov@yandex.ru");
        contact.setNumber("+79272275907");
        return contact;
    }
}
