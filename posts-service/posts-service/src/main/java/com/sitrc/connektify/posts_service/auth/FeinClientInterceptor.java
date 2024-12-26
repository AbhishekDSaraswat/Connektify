package com.sitrc.connektify.posts_service.auth;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeinClientInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        Long userId = UserContextHolder.getCurrentUserId();
        if(userId != null){
            requestTemplate.header("X-User-Id",userId.toString());
        }

    }
}
