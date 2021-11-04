package com.webvarlamov.aoptest.e13.service;

import org.springframework.stereotype.Service;

@Service
public class IWrappedServiceImpl implements IWrapperService {
    @Override
    public Object getData(Object body) {
        return "Some data";
    }
}
