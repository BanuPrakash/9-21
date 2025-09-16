package com.example.springjfrdemo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdk.jfr.Event;
import jdk.jfr.Name;
import jdk.jfr.StackTrace;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TraceHandler implements HandlerInterceptor {

    @Name("HttpRequest")
    @StackTrace(false)
    static class HttpRequestEvent extends Event {
        @Name("Request Path")
        public  String requestURI;
    }

    private  HttpRequestEvent event;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        event = new HttpRequestEvent();
        event.begin();
        return  true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        event.requestURI = request.getRequestURI();
        event.end();
        event.commit(); // write to buffer
    }
}
