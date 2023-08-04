package com.ssm.spring.service.impl;

import com.ssm.spring.dao.UserDAO;
import com.ssm.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserServiceImpl
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/4 14:04
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;


    @Override
    public void saveUser() {
        System.out.println("在UserServiceImpl内 保存用户");
        userDAO.saveUser();
    }
}
