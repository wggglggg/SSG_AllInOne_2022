package com.ssm.spring.aop;

import com.ssm.spring.aop.xml.Calculator;
import com.ssm.spring.aop.xml.CalculatorImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: AOPByAnnotationTest
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/5 16:47
 * @Version 1.0
 */
public class AOPByAnnotationTest {

    @Test
    public void testAOPByAnnotation(){
        ApplicationContext context = new ClassPathXmlApplicationContext("calculator.xml");
        Calculator calculator = context.getBean(Calculator.class);
//        calculator.div(1,0);            //java.lang.ArithmeticException: / by zero
        calculator.add(1,2);
    }
}
