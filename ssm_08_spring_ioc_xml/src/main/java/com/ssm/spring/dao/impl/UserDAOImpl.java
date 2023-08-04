package com.ssm.spring.dao.impl;

import com.ssm.spring.dao.UserDAO;

/**
 * ClassName: UserDAOImpl
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/4 14:02
 * @Version 1.0
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public void saveUser() {
        System.out.println("UserDAO内 保存成功");
    }
}
