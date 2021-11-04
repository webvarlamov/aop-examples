package com.webvarlamov.aoptest.e13.service;

import org.springframework.stereotype.Service;

@Service
public interface IWrapperService {
    Object getData(Object body);
}
