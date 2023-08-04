package com.ssm.spring.service.impl;

import com.ssm.spring.dao.UserDAO;
import com.ssm.spring.service.UserService;

/**
 * ClassName: UserServiceImpl
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/4 14:04
 * @Version 1.0
 */
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void saveUser() {
        System.out.println("在UserServiceImpl内 保存用户");
        userDAO.saveUser();
    }
}
