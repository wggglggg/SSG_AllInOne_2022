package com.ssm.mybatis.test;

import com.ssm.mybatis.bean.User;
import com.ssm.mybatis.mapper.SpecialSQLMapper;
import com.ssm.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.List;

/**
 * ClassName: SpecialSQLMapperTest
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/2 11:17
 * @Version 1.0
 */
public class SpecialSQLMapperTest {

    @Test
    public void testFuzzyQuery() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> userList = mapper.getUserByLike("a");
        userList.forEach(System.out::println);
    }

    @Test
    public void testDeleteMoreUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        mapper.deleteMoreUser("1,2");
    }

    @Test
    public void testGetUserList() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> userList = mapper.getUserList("t_user");
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        mapper.insertUser(new User(null, "COCO", "ok", 48, "f", "coco@126.com"));

    }

    @Test
    public void testJDBC(){
        try {
            Class.forName("");
            Connection connection = DriverManager.getConnection("", "", "");
            String sql = "insert into t_user values()";
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            ResultSet resultSet = ps.getGeneratedKeys();
            resultSet.next();
            int id = resultSet.getInt(1);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
