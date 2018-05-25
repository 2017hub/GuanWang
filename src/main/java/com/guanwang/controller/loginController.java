package com.guanwang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
