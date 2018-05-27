package com.guanwang.utils;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Map;
import java.util.Set;

public class UploadFiles {
    public static void uploadFiles(HttpServletRequest request, MultipartRequest files){
       try {
        Map<String,MultipartFile> filesMap=files.getFileMap();
        Set<String> keySet =filesMap.keySet();
        for (String key:keySet) {
            MultipartFile file=filesMap.get(key);
            String UUID= java.util.UUID.randomUUID().toString();
            String originalFilename= file.getOriginalFilename();//获取文件名
            String path=request.getServletContext().getRealPath("/upload");//动态获取路径
            System.out.println("-------->"+path);
            //截取path,在webapps之前的路径
          // String basePath= path.split("webapps")[0]+"webapps\\upload";
           //判断该目录下是否有upload文件夹,如果没有则创建
//           File uploadFile=new File(basePath);
            File uploadFile=new File(path);
            if(!uploadFile.exists()){
                uploadFile.mkdir();
            }
            //保存文件
//            String filePath=basePath+"\\"+UUID+originalFilename;
            String filePath=path+"\\"+UUID+originalFilename;
            file.transferTo(new File(filePath));
        }
        }catch (Exception e){
           e.printStackTrace();
       }

        }
}
