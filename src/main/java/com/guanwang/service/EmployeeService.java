package com.guanwang.service;

import com.guanwang.entity.Employee;

public interface EmployeeService {

    //动态SQL语句添加员工
    public void addEmpsById(Employee employee);
}
