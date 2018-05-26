package com.guanwang.controller;

import com.guanwang.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * springmvc重定向和转发
 */
@Controller
public class loginController {
    @RequestMapping("/login")
    public String login(String username,String pwd){
        System.out.println("------->"+username+"---"+pwd);

        if("admin".equals(username)&&"123".equals(pwd)){

            return "success";
        }
        return "redirect:/index.jsp";
    }
@RequestMapping("/loginJson")
@ResponseBody
public Employee entityToJson(){

        Employee employee=new Employee();
        employee.setUsername("王麻子");
        employee.setPwd("123");
        employee.setIphone("1268798");
        employee.setEmaile("123456@qq.com");
        employee.seteId(10000);
        String date="2018-10-09 12:30:30";
       Timestamp timestamp =Timestamp.valueOf(date);
        employee.setJobDate(timestamp);
        employee.setAddress("贵阳市人民广场");
    System.out.println("---------json----->");
        return employee;
}

/**
 * 返回值为map
 */
@ResponseBody
@RequestMapping("/loginMap")
public Map<String,Object> loginMap(){
    Map<String,Object> map=new HashMap<String ,Object>();
    map.put("name","jieke");
    map.put("age",25);
    return map;
}

/**
 * 返回值是List集合
 */
@RequestMapping("/loginList")
@ResponseBody
public List<Map<String,Object>> loginList(){
    List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();

    Map<String,Object> map=new HashMap<>();
    map.put("name","jack");
    map.put("age","24");

    Map<String,Object> map1=new HashMap<>();
    map1.put("name","wenjie");
    map1.put("age","26");

    list.add(map);
    list.add(map1);

    return list;
}

}
