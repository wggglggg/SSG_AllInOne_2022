package com.ssm.springmvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.UUID;

/**
 * ClassName: FileUpDownController
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/9 20:15
 * @Version 1.0
 */
@Controller
public class FileUpDownController {

    // 上传功能优化，解决同名后覆盖的问题
    @RequestMapping("/test/up")
    public String testUp(MultipartFile upload, HttpSession session) throws IOException {
        //获取上传文件的文件名
        String originalFilename = upload.getOriginalFilename();

        //处理文件重名问题 .jpg  .png
        String originalFilenameSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        originalFilename = UUID.randomUUID().toString() + originalFilenameSuffix;

        //获取服务器中photo目录的路径
        ServletContext servletContext = session.getServletContext();
        String uploadPath = servletContext.getRealPath("upload");

        File uploadFilepath = new File(uploadPath);
        if (!uploadFilepath.exists()){
            uploadFilepath.mkdir();
        }

        String phonePath = uploadPath + File.separator + originalFilename;

        //实现上传功能
        upload.transferTo(new File(phonePath));

        return "success";

    }


    // 上传功能
//    @RequestMapping("/test/up")
//    public String testUp(MultipartFile upload, HttpSession session) throws IOException {
//        //获取上传的文件的文件名
//        String originalFilename = upload.getOriginalFilename();
//
//        //获取服务器中photo目录的路径
//        ServletContext servletContext = session.getServletContext();
//        String uploadPath = servletContext.getRealPath("upload");
//
//        File uploadFilepath = new File(uploadPath);
//        if (!uploadFilepath.exists()){
//            uploadFilepath.mkdir();
//        }
//
//        String phonePath = uploadPath + File.separator + originalFilename;
//
//        //实现上传功能
//        upload.transferTo(new File(phonePath));
//
//        return "success";
//
//    }

    // 下载功能
    @RequestMapping("/test/down")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();

        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("imgs");
        // File.separator = \
        // realPath = C:\Users\wggglggg\OneDrive\venvs\JavaProjects\SSM\SSG_AllInOne_2022\out\artifacts\ssm_16_springmvc_ajax_war_exploded\imgs\1.jpg
        realPath = realPath + File.separator + "1.jpg";
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组，is.available()字节数,也就长度 获取输入流所对应文件的字节数 类似 byte[] buffer = new byte[1024];
        byte[] buffer = new byte[is.available()];
        //将流读到字节数组中, buffer就是文件内容
        is.read(buffer);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String ,String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字, 固定写法,文件名可变, attachment附件
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
        //设置响应状态码
        HttpStatus httpStatusCode = HttpStatus.OK;

        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(buffer, headers, httpStatusCode);
        //关闭输入流
        is.close();

        return responseEntity;

    }

}
