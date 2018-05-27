package com.guanwang.controller;

import com.guanwang.entity.OrgUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterContorller {
    @RequestMapping("/orgUser")
    public String registerUser(@Valid OrgUser orgUser, BindingResult bindingResult){
        System.out.println("-------register------>");
        boolean flag =bindingResult.hasErrors();//检验数据是否有错
        System.out.println("------flag----->"+flag);
        if(flag){//数据有错
            //将对应字段的信息打印出来
           List<FieldError> errorList = bindingResult.getFieldErrors();//获取所有字段对应的信息
            for (FieldError fieldError:errorList) {
               String fieldName= fieldError.getField();//获取属性名
                String message=fieldError.getDefaultMessage();//获取属性字段对应的错误提示信息
                System.out.println("-------->"+fieldName+"====="+message);
            }
        }else {
            System.out.println("----------->调用业务方法");
        }


        System.out.println(orgUser);
        return "success";
    }
}
