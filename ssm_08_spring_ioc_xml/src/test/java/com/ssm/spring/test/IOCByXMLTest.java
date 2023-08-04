package com.ssm.spring.test;

import com.ssm.spring.bean.Clazz;
import com.ssm.spring.bean.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: IOCByXMLTest
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/3 19:08
 * @Version 1.0
 */
public class IOCByXMLTest {

    @Test
    public void testDI(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Clazz clazz = context.getBean("clazzOne", Clazz.class);
        System.out.println("clazz = " + clazz);
    }

    @Test
    public void testIOC(){
        //获取IOC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean
        //        Student student = (Student) context.getBean("student");
//        Student student = context.getBean(Student.class);
//        Student student = context.getBean("studentTwo",Student.class);
//        Student student = context.getBean("studentThree", Student.class);
//        Student student = context.getBean("studentFive", Student.class);
//        System.out.println("student = " + student);
        Student student = context.getBean("studentSix", Student.class);
        System.out.println("student = " + student);
    }
}
