package com.webvarlamov.aoptest.e13.configuration;

import com.webvarlamov.aoptest.e13.service.IWrapperService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
@AllArgsConstructor
public class ResponseWrapperAutoConfiguration {
    private final IWrapperService wrapperService;

    @Bean
    @ConditionalOnMissingBean
    public ResponseWrapperAdvice responseWrapperAdvice() {
        return new ResponseWrapperAdvice(wrapperService);
    }
}
