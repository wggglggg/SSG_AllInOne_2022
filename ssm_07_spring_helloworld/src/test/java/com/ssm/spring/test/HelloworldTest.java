package com.ssm.spring.test;

import com.ssm.spring.bean.HelloWorld;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: HelloworldTest
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/3 18:47
 * @Version 1.0
 */
public class HelloworldTest {

    @Test
    public void testHelloWorld(){
        //获取IOC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取IOC容器中的bean
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");

        helloWorld.sayHello();
    }
}
