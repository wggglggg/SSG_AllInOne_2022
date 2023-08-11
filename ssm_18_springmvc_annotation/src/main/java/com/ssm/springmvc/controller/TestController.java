package com.ssm.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: TestController
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/10 20:30
 * @Version 1.0
 */
@Controller
public class TestController {

    @RequestMapping("/test/hello")
    public String testHello(){

        return "test_hello";
    }
}
