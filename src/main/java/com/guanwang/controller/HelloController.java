package com.guanwang.controller;


import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/hello")
public class HelloController {
   @RequestMapping(value = "/mvc",method =RequestMethod.GET)
    public String printHello(@RequestParam("userId") Integer userId, Model model) {
       System.out.println("输出---ID--"+userId);
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
