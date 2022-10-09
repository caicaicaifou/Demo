package com.exec.spring.ioc.dao;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
    private EmployeeDao() {
        System.out.println(this);
    }
}
