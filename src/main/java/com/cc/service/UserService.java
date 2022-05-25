package com.cc.service;


import com.cc.entity.User;



/**
 * @Author cc
 * @PackageName spring
 * @Package com.cc.service.impl
 * @Date 2022/5/23 9:47
 * @Version 1.0
 */
public interface UserService {
    User login(String name, String pwd);


}
