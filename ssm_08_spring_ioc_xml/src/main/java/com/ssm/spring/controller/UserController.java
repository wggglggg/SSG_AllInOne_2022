package com.ssm.spring.controller;

import com.ssm.spring.service.UserService;

/**
 * ClassName: UserController
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/4 14:06
 * @Version 1.0
 */
public class UserController {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void saveUser(){
        System.out.println("在UserController内 保存用户");
        userService.saveUser();
    }
}
