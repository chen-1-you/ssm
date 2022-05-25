package com.cc.mapper;

import java.util.List;
import java.util.Set;

/**
 * @Author cc
 * @PackageName spring
 * @Package com.cc.mapper
 * @Date 2022/5/23 13:35
 * @Version 1.0
 */
public interface PermMapper {
    /*根据用户名找权限*/
    Set<String> queryPerms(String name);

}
