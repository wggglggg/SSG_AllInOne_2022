package com.ssm.spring.proxy;

import org.junit.jupiter.api.Test;

/**
 * ClassName: ProxyTest
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/5 15:41
 * @Version 1.0
 */
public class ProxyTest {

    @Test
    public void testProxy(){
        // StaticProxy静态代理
//        CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorImpl());
//        proxy.add(1, 2);
        // 动态代理
        ProxyFactory factory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) factory.getProxy();
        proxy.add(1,2);
        System.out.println();
        proxy.sub(1,2);
        System.out.println();
        proxy.mul(1,2);
        System.out.println();
        proxy.div(1,2);

    }
}
