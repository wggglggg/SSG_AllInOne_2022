package com.ssm.spring.test;

import com.ssm.spring.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: FactoryBeanTest
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/4 13:52
 * @Version 1.0
 */
public class FactoryBeanTest {

    @Test
    public void testFactoryBean(){
    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-factory.xml");
        User user = context.getBean(User.class);
        System.out.println("user = " + user);

    }


}
