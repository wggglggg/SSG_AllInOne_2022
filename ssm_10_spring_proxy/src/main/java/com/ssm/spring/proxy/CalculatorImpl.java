package com.ssm.spring.proxy;

/**
 * ClassName: CalculatorImpl
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/5 15:36
 * @Version 1.0
 */
public class CalculatorImpl implements Calculator{
    @Override
    public int add(int i, int j) {
        int result = i + j;
        System.out.println("result = " + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;
        System.out.println("result = " + result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j;
        System.out.println("result = " + result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;
        System.out.println("result = " + result);
        return result;
    }
}
