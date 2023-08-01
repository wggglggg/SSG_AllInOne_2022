package com.ssm.mybatis.mapper;

import com.ssm.mybatis.bean.User;

/**
 * ClassName: UserMapper
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/1 21:13
 * @Version 1.0
 */
public interface UserMapper {

    User getUserByName(String username);
}
