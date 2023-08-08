package com.ssm.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: TestViewController
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/8 9:10
 * @Version 1.0
 */
@Controller
public class TestViewController {
    @RequestMapping("/test/view/thymeleaf")
    public String testThymeleafView(){

        return "success";
    }

    // 测试内部转发到某个页面
    @RequestMapping("/test/view/forward")
    public String testInternalResourceView(){

        return "forward:/test/model";
    }

    // 测试重定向到某个页面,用户点击某个链接,服务端收到请求后会通过用户重新向另一个网页发请求,
    // 当然这是自动完成的.与内部转发区别在于网址变成了新网址,内部转发后网址却是原网址
    @RequestMapping("/test/view/redirect")
    public String testRedirectView(){

        return "redirect:/test/model";
    }
}
