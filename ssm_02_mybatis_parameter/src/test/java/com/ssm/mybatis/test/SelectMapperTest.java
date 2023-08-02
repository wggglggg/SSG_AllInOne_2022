package com.ssm.mybatis.test;

import com.ssm.mybatis.bean.User;
import com.ssm.mybatis.mapper.SelectMapper;
import com.ssm.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.sql.SQLData;
import java.util.List;
import java.util.Map;

/**
 * ClassName: SelectMapperTest
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/2 11:03
 * @Version 1.0
 */
public class SelectMapperTest {

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(2);
        System.out.println("user = " + user);
    }

    @Test
    public void testGetALlUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> userList = mapper.getAllUser();
        System.out.println("user = " + userList);
    }

    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println("count = " + count);
    }

    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getUserByIdToMap(2);
        System.out.println("map = " + map);
    }

    @Test
    public void testGetAllToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getAllUserToMap();
        System.out.println("map = " + map);
    }
}
