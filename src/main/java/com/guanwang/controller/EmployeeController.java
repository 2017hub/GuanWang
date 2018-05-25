package com.guanwang.controller;

import com.guanwang.entity.Employee;
import com.guanwang.service.EmployeeService;
import com.guanwang.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
   EmployeeService employeeService=new EmployeeServiceImpl();

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public  String addEmpsById(Employee employee){
        System.out.println("------------>");
        employeeService.addEmpsById(employee);
        return  "employee";
    }
}
