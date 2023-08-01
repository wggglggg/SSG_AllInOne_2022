package com.ssm.mybatis.mapper;

import com.ssm.mybatis.bean.User;

import java.util.List;

/**
 * ClassName: UserMapper
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/1 15:59
 * @Version 1.0
 */
public interface UserMapper {

    /**
     * 添加用户
     * @return
     */
    int insertUser();

    /**
     * 修改用户
     * @return
     */
    int updateUser();

    /**
     * 删除用户
     * @return
     */
    int deleteUser();

    /**
     * 查找一个用户
     * @return
     */
    User getUserById();

    /**
     * 查找所有用户
     * @return
     */
    List<User> getAllUser();


}
