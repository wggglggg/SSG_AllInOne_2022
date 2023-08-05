package com.ssm.spring.aop.annotation;

import org.springframework.stereotype.Component;

/**
 * ClassName: CalculatorImpl
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/5 14:56
 * @Version 1.0
 */
@Component
public class CalculatorImpl implements Calculator {

    @Override
    public int add(int i, int j) {

        // 通过目标对象来实现核心业务逻辑
        int result = i + j;
        System.out.println("result = " + result);


        return result;
    }

    @Override
    public int sub(int i, int j) {
        // 通过目标对象来实现核心业务逻辑
        int result = i - j;
        System.out.println("result = " + result);
        return result;
    }

    @Override
    public int mul(int i, int j) {

        // 通过目标对象来实现核心业务逻辑
        int result = i * j;
        System.out.println("result = " + result);
        return result;
    }

    @Override
    public int div(int i, int j) {


        // 通过目标对象来实现核心业务逻辑
        int result = i / j;
        System.out.println("result = " + result);

        return result;
    }
}
