package com.cc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author cc
 * @PackageName spring
 * @Package com.cc.entity
 * @Date 2022/5/23 9:44
 * @Version 1.0
 */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class User {
        private Integer id;
        private String name;
        private String pwd;
        private String salt;
    }

