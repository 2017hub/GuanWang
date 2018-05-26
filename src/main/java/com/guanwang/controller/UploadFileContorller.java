package com.guanwang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


/**
 * 文件上传
 */
@RequestMapping("/upload")
@Controller
public class UploadFileContorller {
    @RequestMapping(value = "/sigonFile",method =RequestMethod.POST)
    public String uploadFile(@RequestParam("bigHeadImage")MultipartFile file) throws IOException {
            //getOriginalFilename()方法是获取上传文件的文件名
       String originalFilename= file.getOriginalFilename();
        System.out.println("------>"+originalFilename);
        //getName()方法是获取上传文件jsp<input>file控件的name值
        System.out.println("------>"+file.getName());

        File  filePath=new File("D:\\upload\\"+originalFilename);

        //将文件上传到指定的路径中
        file.transferTo(filePath);
        return "success";
    }
}
