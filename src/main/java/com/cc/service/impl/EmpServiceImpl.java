package com.cc.service.impl;

import com.cc.entity.Dept;
import com.cc.entity.Emp;
import com.cc.entity.User;
import com.cc.mapper.DeptMapper;
import com.cc.mapper.EmpMapper;
import com.cc.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author cc
 * @PackageName spring
 * @Package com.cc.service.impl
 * @Date 2022/5/23 11:34
 * @Version 1.0
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Emp> queryEmps() {
        List<Emp> emps = this.empMapper.queryAll();
        return emps;
    }

    @Override
    public List<Dept> queryDepts() {
        List<Dept> depts = this.deptMapper.queryAll();
        return depts;
    }

    @Override
    public void add(Emp emp) {
        this.empMapper.insert(emp);
    }

    @Override
    public Emp queryById(Integer id) {
        Emp emp = this.empMapper.getById(id);
        return emp;
    }

    @Override
    public void update(Emp emp) {
        this.empMapper.update(emp);
    }

    @Override
    public void delete(Integer id) {
        this.empMapper.deleteById(id);
    }


}
