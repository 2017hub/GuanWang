package com.guanwang.service.impl;

import com.guanwang.dao.mapper.EmployeeMapper;
import com.guanwang.entity.Employee;
import com.guanwang.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public void addEmpsById(Employee employee) {
        employeeMapper.addEmpsById(employee);

    }
}
