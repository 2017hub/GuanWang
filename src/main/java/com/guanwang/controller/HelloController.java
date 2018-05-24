package com.guanwang.controller;


import com.guanwang.entity.Employee;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

@SessionAttributes("emp")
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
    @RequestMapping("/test")
   public  String testParam(@RequestParam("username") String username,@RequestParam("age") int age){
    System.out.println("------>"+username+"----"+age);
       return  "hello";
   }


   //用pojo作为参数
    @RequestMapping("/pojo")
    public String testPojo(Employee employee){
        System.out.println("------->"+employee);
       return "hello";
    }
//使用原生API作为参数
    @RequestMapping("/testApi")
public void testApi(Writer out) throws IOException {
       out.write("123333");
}
//modelAndview作为返回值
    @RequestMapping("/model")
    public ModelAndView testModelAndView(){
       String view="hello";
       ModelAndView modelAndView=new ModelAndView(view);
       modelAndView.addObject("time",new Date());
       return modelAndView;
    }

    /**
     * Map类型作为参数，开发中比较常用，就是页面返回一个map集合
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String ,Object> map){
        map.put("names",Arrays.asList("tom","jerry","wenjie"));

        return "hello";
    }

    /**
     * 把模型数据放在session域中
     */
    @RequestMapping("/testSession")
    public String testSession(Map<String ,Object> map){
        Employee employee=new Employee();
        employee.setUsername("tom");
        employee.setIphone("152878787");
        map.put("emp",employee);
        return "hello";
    }

}
