//package com.ssm.spring.test;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
//
//import java.util.List;
//
///**
// * ClassName: JdbcTemplateTest
// * Description:
// *
// * @Author wggglggg
// * @Create 2023/8/6 10:25
// * @Version 1.0
// */
//@SpringJUnitConfig(locations = "classpath:spring-jdbc.xml")
//public class JdbcTemplateTest {
//
//
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    @Test
//    public void testInsert(){
//        String sql = "insert into t_user values(null, ?,?,?,?,?)";
//        Integer count = jdbcTemplate.update(sql, "caicande", "ok", 40, "f", "ccd@126.com");
//        System.out.println("count = " + count);
//    }
//
//    @Test
//    public void testGetUserById(){
//        String sql = "select * from t_user where id = ?";
//        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 1);
//        System.out.println("user = " + user);
//    }
//
//    @Test
//    public void testGetAllUser(){
//        String sql = "select * from t_user";
//        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
//        userList.forEach(System.out::println);
//    }
//
//    @Test
//    public void testGetCount(){
//        String sql = "select count(*) from t_user";
//        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
//        System.out.println("count = " + count);
//
//    }
//
//}
