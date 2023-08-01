package com.ssm.mybatis.test;

import com.ssm.mybatis.bean.User;
import com.ssm.mybatis.mapper.UserMapper;
import com.ssm.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

/**
 * ClassName: ParameterTest
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/1 21:25
 * @Version 1.0
 */
public class ParameterTest {

    @Test
    public void testGetUserByUserName(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByName("COCO");
        System.out.println("user = " + user);
    }
}
