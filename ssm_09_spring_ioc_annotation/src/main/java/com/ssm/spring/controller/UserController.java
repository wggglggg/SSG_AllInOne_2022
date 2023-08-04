package com.ssm.spring.controller;

import com.ssm.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * ClassName: UserController
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/4 14:06
 * @Version 1.0
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public void saveUser(){
        System.out.println("在UserController内 保存用户");
        userService.saveUser();
    }
}
