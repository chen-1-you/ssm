package com.cc.mapper;

import com.cc.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author cc
 * @PackageName spring
 * @Package com.cc.mapper
 * @Date 2022/5/23 9:45
 * @Version 1.0
 */
public interface UserMapper {
    User getByNameAndPwd(@Param("name") String name, @Param("pwd") String pwd);
    User getByName( String name);

}
