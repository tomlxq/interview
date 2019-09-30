package com.example.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/11
 */
@Slf4j
public class LogHandlerInterceptorAdapter extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        MDC.put("userId", "tomluo");
        MDC.put("sessionId ", request.getHeader("SessionId"));
        MDC.put("requestId", request.getHeader("RequestId"));
        return true;
    }
}
