package com.cc.service;

import com.cc.entity.Dept;
import com.cc.entity.Emp;


import java.util.List;

/**
 * @Author cc
 * @PackageName spring
 * @Package com.cc.service
 * @Date 2022/5/23 11:33
 * @Version 1.0
 */
public interface EmpService {
    List<Emp> queryEmps();
    List<Dept>queryDepts();
    void add(Emp emp);
    Emp queryById(Integer id);
    void update(Emp emp);
    void delete(Integer id);
}
