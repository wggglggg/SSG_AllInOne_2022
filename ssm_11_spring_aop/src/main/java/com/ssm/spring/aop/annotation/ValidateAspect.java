package com.ssm.spring.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * ClassName: ValidateAspect
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/5 21:08
 * @Version 1.0
 */
@Component
@Aspect
@Order(1)
public class ValidateAspect {

    @Before("execution(* com.ssm.spring.aop.annotation.CalculatorImpl.*(..))")
    public void beforeMethod(){
        System.out.println("ValidateAspect-->前置通知");
    }
}
