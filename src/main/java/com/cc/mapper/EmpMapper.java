package com.cc.mapper;

import com.cc.entity.Emp;

import java.util.List;

/**
 * @Author cc
 * @PackageName spring
 * @Package com.cc.mapper
 * @Date 2022/5/23 11:13
 * @Version 1.0
 */
public interface EmpMapper {
    List<Emp> queryAll();
    void insert(Emp emp);
    Emp getById(Integer id);
    void update(Emp emp);
    void deleteById(Integer id);
}
