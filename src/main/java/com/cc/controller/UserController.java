package com.cc.controller;

import com.cc.entity.User;

import com.cc.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author cc
 * @PackageName spring
 * @Package com.cc.controller
 * @Date 2022/5/23 9:21
 * @Version 1.0
 */
@Controller
public class UserController {

   /* @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(User user, Map map, HttpSession session){
        System.out.println("name:--->" + user.getName());
        System.out.println("pwd:--->" + user.getPwd());

        User u =  this.userService.login(user.getName(), user.getPwd());
        if(u != null){
            session.setAttribute("user",u);
            return "redirect:main.html";
        }
        map.put("error","用户名或者密码不正确!");
        return "index";

    }*/

    @RequestMapping("/login")
    public String shiroLogin(User user, Map map, HttpSession session){
        System.out.println("name:--->" + user.getName());
        System.out.println("pwd:--->" + user.getPwd());

        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(),user.getPwd());

        Subject subject = SecurityUtils.getSubject();//拿到subject
        try{
            subject.login(token);
            return "redirect:main.html";
        }catch (Exception e){
            map.put("error","登录失败!");
            return "index";
        }



    }

}