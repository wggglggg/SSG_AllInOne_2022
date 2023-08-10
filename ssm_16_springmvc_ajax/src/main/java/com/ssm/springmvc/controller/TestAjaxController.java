package com.ssm.springmvc.controller;

import com.ssm.springmvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: TestAjaxController
 * Description:
 *
 * 1、@RequestBody：将请求体中的内容和控制器方法的形参进行绑定
 * 2、使用@RequestBody注解将json格式的请求参数转换为java对象
 * a>导入jackson的依赖
 * b>在SpringMVC的配置文件中设置<mvc:annotation-driven />
 * c>在处理请求的控制器方法的形参位置，直接设置json格式的请求参数要转换的java类型的形参，使用@RequestBody注解标识即可
 * 3、@ResponseBody：将所标识的控制器方法的返回值作为响应报文的响应体响应到浏览器
 * 4、使用@ResponseBody注解响应浏览器json格式的数据
 * a>导入jackson的依赖
 * b>在SpringMVC的配置文件中设置<mvc:annotation-driven />
 * c>将需要转换为json字符串的java对象直接作为控制器方法的返回值，使用@ResponseBody注解标识控制器方法
 * 就可以将java对象直接转换为json字符串，并响应到浏览器
 *
 * 常用的Java对象转换为json的结果：
 * 实体类-->json对象
 * map-->json对象
 * list-->json数组
 *
 * @Author wggglggg
 * @Create 2023/8/9 10:38
 * @Version 1.0
 */
@Controller
public class TestAjaxController {

    @RequestMapping("/test/ajax")
    public void testAjax(@RequestBody String requestBody, Integer id, HttpServletResponse response) throws IOException {
        // id = 1001
        System.out.println("id = " + id);
        // requestBody = {"username":"caixingjuan","password":"ok"}
        System.out.println("requestBody = " + requestBody);
        response.getWriter().write("hello.axios");

    }

    // 方式一用map接收
    @RequestMapping("/test/requestBody/json")
    public void testRequestBody(@RequestBody Map<String, Object> map, HttpServletResponse response) throws IOException {
        System.out.println("map = " + map);

        response.getWriter().write("hello, RequestBody");
    }

    // 方式二 用bean实体类接受
    @RequestMapping("/test/requestBody/bean/json")
    public void testRequestBody(@RequestBody User user, HttpServletResponse response) throws IOException {
        System.out.println("user = " + user);

        response.getWriter().write("hello, RequestBody by bean");
    }

    // 方式三 用List接收
    @RequestMapping("/test/requestBody/list/json")
    public void testRequestBodyByList(@RequestBody List<User> userList, HttpServletResponse response) throws IOException {
        userList.forEach(System.out::println);

        response.getWriter().write("hello, RequestBody by list");
    }

    @RequestMapping("/test/responseBody")
    @ResponseBody
    public String testResponseBody(){

        return "success";
    }

    @RequestMapping("/test/responseBody/list/json")
    @ResponseBody
    public List<User> testResponseBodyByList(){
        User user1 = new User(1001, "admin1", "123456", 20, "男");
        User user2 = new User(1002, "admin2", "123456", 20, "男");
        User user3 = new User(1003, "admin3", "123456", 20, "男");

        List<User> userList = Arrays.asList(user1, user2, user3);

        return userList;
    }

    @RequestMapping("/test/responseBody/map/json")
    @ResponseBody
    public Map<String, Object> testResponseBodyByMap(){
        User user1 = new User(1001, "admin1", "123456", 20, "男");
        User user2 = new User(1002, "admin2", "123456", 20, "男");
        User user3 = new User(1003, "admin3", "123456", 20, "男");

        Map<String , Object> map = new HashMap<>();
        map.put("1001", user1);
        map.put("1002", user2);
        map.put("1003", user3);

        return map;

    }

    @RequestMapping("/test/responseBody/user/json")
    @ResponseBody
    public User testResponseBodyByUser(){

        return new User(1007, "yeyuqqing", "ok", 55, "女");

    }


}
