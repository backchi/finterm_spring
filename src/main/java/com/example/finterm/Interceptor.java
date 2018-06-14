package com.example.finterm;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Interceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            if (request.getSession().getAttribute("login") == null) {
                response.sendRedirect("/list");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
}
