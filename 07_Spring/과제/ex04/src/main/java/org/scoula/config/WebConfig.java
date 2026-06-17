package com.example.config; // 본인 패키지에 맞게 수정

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;

@Configuration
public class WebConfig {

    @Value("${file.upload.location}")
    private String location;

    @Value("${file.upload.max-file-size}")
    private long maxFileSize;

    @Value("${file.upload.max-request-size}")
    private long maxRequestSize;

    @Value("${file.upload.file-size-threshold}")
    private int fileSizeThreshold;

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        return new MultipartConfigElement(
                location,
                maxFileSize,
                maxRequestSize,
                fileSizeThreshold
        );
    }
}