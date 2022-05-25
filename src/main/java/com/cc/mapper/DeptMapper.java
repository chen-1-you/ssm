package com.cc.mapper;

import com.cc.entity.Dept;

import java.util.List;

/**
 * @Author cc
 * @PackageName spring
 * @Package com.cc.mapper
 * @Date 2022/5/23 13:35
 * @Version 1.0
 */
public interface DeptMapper {
    List<Dept> queryAll();

}
