package com.ssm.mybatis.test;

import com.ssm.mybatis.bean.User;
import com.ssm.mybatis.mapper.UserMapper;
import com.ssm.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void testCheckLogin(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLogin("COCO", "123456");
        System.out.println("user = " + user);
    }

    @Test
    public void testCheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "COCO");
        map.put("password", "123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println("user = " + user);
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user =new User(null, "caixingjuan", "123456", 55, "f", "cxj@126.com");
        mapper.insertUser(user);
    }

    @Test
    public void testCheckLoginByParam(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLoginByParam("caixingjuan", "123456");
        System.out.println("user = " + user);
    }
}
