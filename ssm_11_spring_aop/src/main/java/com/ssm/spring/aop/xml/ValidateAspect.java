package com.ssm.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

/**
 * ClassName: ValidateAspect
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/5 21:40
 * @Version 1.0
 */
@Component
public class ValidateAspect {

    public void beforeMethod(JoinPoint joinPoint){
        System.out.println("ValidateAspect-->前置通知");
    }
}
