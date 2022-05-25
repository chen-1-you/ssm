package com.cc.service.impl;
import com.cc.entity.User;
import com.cc.mapper.UserMapper;
import com.cc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @Author cc
 * @PackageName spring
 * @Package com.cc.service.impl
 * @Date 2022/5/23 9:47
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String name, String pwd) {

        User user = this.userMapper.getByNameAndPwd(name, pwd);
        return user;
    }


    }


