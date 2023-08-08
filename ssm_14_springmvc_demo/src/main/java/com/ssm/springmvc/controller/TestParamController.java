package com.ssm.springmvc.controller;

import com.ssm.springmvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * ClassName: TestParamController
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/7 21:51
 * @Version 1.0
 */
@Controller
public class TestParamController {

    // 方式一 通过servletAPI
    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        Cookie[] cookies = request.getCookies();

        return "success";
    }

    // 方式二 通过制品方法的形象@RequestParam
    @RequestMapping("/param")
    public String getParam(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password,
            @RequestHeader(value = "referer") String referer,
            @CookieValue(value = "Pycharm-cb5a263f") String jsessionId
    ){
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("referer = " + referer);
        System.out.println("Pycharm-cb5a263f = " + jsessionId);


        return "success";
    }

    //方式三 通过Bean实体类来接受 要求与bean实体类中的属性
    @RequestMapping("/param/bean")
    public String getParamByBean(User user){

        System.out.println("user = " + user);

        return "success";
    }
}
