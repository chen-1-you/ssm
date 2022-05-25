package com.cc.interceptor;


import com.cc.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author cc
 * @PackageName spring
 * @Package com.cc.interceptor
 * @Date 2022/5/23 10:34
 * @Version 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取当前用户是否登录
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null){
            request.setAttribute("error","用户未登录！");
            request.getRequestDispatcher("index.html").forward(request,response);
            return false;
        }
        return true;
    }
}
