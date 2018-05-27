package com.guanwang.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FieldValidate {
    /**
     * 数据校验属性的值是否正确的方法
     * BindingResult 类型
     * @param bindingResult
     * @return：如果正确则返回null,否则返回封装提示信息的map
     */
    public static Map<String ,Object> fieldValidate(BindingResult bindingResult){
        Map<String ,Object> errorMap=null;
        boolean flag=bindingResult.hasErrors();//判断数据是否有错
        if(flag){//有错
            errorMap=new HashMap<String, Object>();
           List<FieldError> errorList =bindingResult.getFieldErrors();
            for (FieldError fieldError: errorList) {
                String fieldName=fieldError.getField();//获取实体类的属性名
                String message=fieldError.getDefaultMessage();//获取实体类的属性对应的提示信息
                errorMap.put(fieldName,message);//把属性名作为key，提示信息为value进行封装
            }
        }
        return errorMap;
    }
}
