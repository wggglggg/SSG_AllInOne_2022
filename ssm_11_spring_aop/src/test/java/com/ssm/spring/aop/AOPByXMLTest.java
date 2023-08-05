package com.ssm.spring.aop;

import com.ssm.spring.aop.xml.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: AOPByXMLTest
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/5 21:45
 * @Version 1.0
 */
public class AOPByXMLTest {

    @Test
    public void testAOPByXML(){
        ApplicationContext context = new ClassPathXmlApplicationContext("aop-xml.xml");
        Calculator calculator = context.getBean(Calculator.class);
//        calculator.div(9,5);
        calculator.div(10,0);
    }

}
