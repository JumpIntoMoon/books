package com.zq.books.security;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @description: description
 * @author: tangYiLong
 * @create: 2018-05-16 15:11
 **/
@Component
public class SecurityInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String sessionKey = request.getParameter("sessionKey");
        //判断是否已有该用户登录的session
        if (session.getAttribute(sessionKey) != null) {
            return true;
        }
        // 跳转登录
        String url = "/auth/loginFail";
        response.sendRedirect(url);
        return false;
    }
}
