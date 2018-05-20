package com.guanwang.dao.mapper;

import com.guanwang.entity.Employee;

public interface EmployeeMapper {
    //查询
    public Employee selectEmployeeById(int eId);

    //增加
    public void addEmployee(Employee employee);

    //删除
    public void delEmployee(int eId);

    //修改
    public void updateEmplyee(Employee employee);
}
