package com.guanwang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;



/**
 * 文件上传
 */
@RequestMapping("/upload")
@Controller
public class UploadFileContorller {
    @RequestMapping(value = "/sigonFile",method =RequestMethod.POST)
    public String uploadFile(@RequestParam("bigHeadImage")MultipartFile file, HttpServletRequest request) throws Exception {
            //getOriginalFilename()方法是获取上传文件的文件名
       String originalFilename= file.getOriginalFilename();
        System.out.println("------>"+originalFilename);
        //getName()方法是获取上传文件jsp<input>file控件的name值
        System.out.println("------>"+file.getName());
        //动态获取上传路径
       String path= request.getServletContext().getRealPath("/upload");
        System.out.println("----->"+path);
      // File  uploadPath=new File("D:\\upload\\"+originalFilename);
        File  uploadPath=new File(path+"\\"+originalFilename);
      //  File  uploadPath=new File(" D:\\develop\\GuanWang\\lake\\src\\main\\webapp\\upload\\"+originalFilename);

        System.out.println("------>"+uploadPath);
        //将文件上传到指定的路径中
        file.transferTo(uploadPath);
        return "success";
    }
}
