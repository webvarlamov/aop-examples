package com.webvarlamov.aoptest.e13.configuration;

import com.webvarlamov.aoptest.e13.annotation.DisableResponseWrapper;
import com.webvarlamov.aoptest.e13.annotation.EnableResponseWrapper;
import com.webvarlamov.aoptest.e13.model.IWrapperModel;
import com.webvarlamov.aoptest.e13.service.IWrapperService;
import lombok.SneakyThrows;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.annotation.Annotation;

@ControllerAdvice(annotations = EnableResponseWrapper.class)
public class ResponseWrapperAdvice implements ResponseBodyAdvice<Object> {
    IWrapperService wrappedService;

    public ResponseWrapperAdvice(IWrapperService wrappedService) {
        this.wrappedService = wrappedService;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        for (Annotation methodAnnotation : returnType.getMethodAnnotations()) {
            if (methodAnnotation.annotationType() == DisableResponseWrapper.class) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Object beforeBodyWrite(
            Object body,
            MethodParameter returnType,
            MediaType selectedContentType,
            Class<? extends HttpMessageConverter<?>> selectedConverterType,
            ServerHttpRequest request,
            ServerHttpResponse response
    ) {
        Class<? extends IWrapperModel> wrappedClass = null;
        for (Annotation annotation : returnType.getContainingClass().getAnnotations()) {
            if (annotation.annotationType() == EnableResponseWrapper.class) {
                wrappedClass = ((EnableResponseWrapper) annotation).wrapperClass();
            }
        }

        if (wrappedClass == null) {
            return body;
        } else {
            return generateResponseWrapper(body, wrappedClass);
        }
    }

    @SneakyThrows
    private Object generateResponseWrapper(Object body, Class<? extends IWrapperModel> wrapperClass) {
        IWrapperModel wrapper = wrapperClass.getDeclaredConstructor().newInstance();
        wrapper.setBody(body);
        wrapper.setData(wrappedService.getData(body));
        return wrapper;
    }
}
