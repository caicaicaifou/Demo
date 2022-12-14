package com.exec.spring.jdbc.dao;

import com.exec.spring.jdbc.entity.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    public Employee findById(Integer eno) {
        String sql = "select * from employee where eno = ?";
        //查询单条数据
        // return jdbcTemplate.queryForObject(sql, new Object[]{eno}, new BeanPropertyRowMapper<Employee>(Employee.class));
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Employee>(Employee.class), eno);
    }

    public List<Employee> findByDname(String dname) {
        String sql = "select * from employee where dname = ?";
        //查询复合数据
        // return jdbcTemplate.query(sql, new Object[]{dname}, new BeanPropertyRowMapper<Employee>(Employee.class));
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class), new Object[]{dname});
    }

    public List<Map<String, Object>> findMapByDname(String dname) {
        String sql = "select eno as empno , salary as s from employee where dname = ?";
        //将查询结果作为Map进行封装
        return jdbcTemplate.queryForList(sql, new Object[]{dname});
    }

    public void insert(Employee employee) {
        String sql = "insert into employee(eno,ename,salary,dname,hiredate) values(?,?,?,?,?)";
        //利用update方法实现数据写入操作
        jdbcTemplate.update(sql, employee.getEno(), employee.getEname(), employee.getSalary(), employee.getDname(), employee.getHiredate());
    }

    public int update(Employee employee) {
        String sql = "UPDATE employee SET ename = ?, salary = ?, dname = ?, hiredate = ? WHERE eno = ?";
        return jdbcTemplate.update(sql, employee.getEname(), employee.getSalary(), employee.getDname(), employee.getHiredate(), employee.getEno());
    }

    public int delete(Integer eno) {
        String sql = "delete from employee where eno = ?";
        return jdbcTemplate.update(sql, eno);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
