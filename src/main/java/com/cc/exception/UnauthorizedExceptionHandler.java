package com.cc.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author cc
 * @PackageName spring
 * @Package com.cc.exception
 * @Date 2022/5/24 22:07
 * @Version 1.0
 */
@ControllerAdvice
@Component
//@RestControllerAdvice
public class UnauthorizedExceptionHandler {

    @ExceptionHandler({UnauthorizedException.class})
    public String unauthorizedException(){

        System.out.println("00000000000000000000000000000000000000");

        return "unauthorized";
    }
}
