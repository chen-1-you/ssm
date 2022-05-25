package com.cc.controller;

import com.cc.entity.Dept;
import com.cc.entity.Emp;
import com.cc.service.EmpService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author cc
 * @PackageName spring
 * @Package com.cc.controller
 * @Date 2022/5/23 10:59
 * @Version 1.0
 */
@Controller
public class EmpController {
    @Autowired
private EmpService empService;
    @GetMapping("/emp/emps")
    public String queryEmps(Map map){
        List<Emp> emps = empService.queryEmps();
        map.put("emps",emps);
        return "emp/list";
    }
    @RequiresPermissions("emp:add")
    @GetMapping("/emp/preAdd")
    public String preAdd(Map map){
        List<Dept> depts = this.empService.queryDepts();
        map.put("depts",depts);
        return "emp/add";
    }
    @RequiresPermissions("emp:add")
    @PostMapping("/emp")
    public String add(Emp emp){
        emp.setStatus(1);
        this.empService.add(emp);
      return "redirect:/emp/emps";
    }
    @RequiresPermissions(value={"emp:update"})
    @GetMapping("/emp/{id}")
    public String preEdit(@PathVariable("id") Integer id,Map map){
        System.out.println(id);
        Emp emp = this.empService.queryById(id);
        List<Dept> depts = this.empService.queryDepts();
        map.put("emp",emp);
        map.put("depts",depts);
        return "emp/edit";
    }
    @RequiresPermissions(value={"emp:update"})
    @PutMapping("/emp")
    public String edit(Emp emp){
        emp.setStatus(1);
      this.empService.update(emp);
        return "redirect:/emp/emps";
    }
    @RequiresPermissions(value={"emp:del"})
    @DeleteMapping("/emp")
    public String delete(Integer id){
    this.empService.delete(id);
        return "redirect:/emp/emps";
    }
}
