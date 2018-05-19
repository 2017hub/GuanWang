package com.guanwang.controller;


import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String printHello(Model model) {
        System.out.println("--------------hello--------------");
       // model.addAttribute("message", "Hello Spring MVC Framework!");
        model.addAttribute("message","hello------------------");
        return "hello";
    }
//@RequestMapping("/hello")
//    public String helloController(HttpRequest request){
//
//        return "hello";
//    }
}
