package com.ssm.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: controller
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/6 21:38
 * @Version 1.0
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String protal(){

        return "index";
    }
    @RequestMapping("/hello")
    public String hello(){

        return "success";
    }
}
