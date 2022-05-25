package com.cc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @Author cc
 * @PackageName spring
 * @Package com.cc.entity
 * @Date 2022/5/23 11:01
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id;
    private String name;
    private Integer gender;
    private Dept dept;
    private Integer status;
}
