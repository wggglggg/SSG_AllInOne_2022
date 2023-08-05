package com.ssm.spring.proxy;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * ClassName: ProxyFactory
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/5 15:44
 * @Version 1.0
 */
public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target){
        this.target = target;
    }
    public Object getProxy(){
        /**
         * ClassLoader loader：指定加载动态生成的代理类的类加载器
         * Class[] interfaces：获取目标对象实现的所有接口的class对象的数组
         * InvocationHandler h：设置代理类中的抽象方法如何重写
         */
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    System.out.println("[动态代理][日志] " + method.getName() + "，参数："+ Arrays.toString(args));
                    result = method.invoke(target, args);
                    System.out.println("[动态代理][日志] "+method.getName()+"，结果："+ result);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("[动态代理][日志] "+method.getName()+"，异常："+e.getMessage());
                } finally {
                    System.out.println("[动态代理][日志] "+method.getName()+"，方法执行完毕");

                }

                return result;
            }
        };

        return Proxy.newProxyInstance(classLoader, interfaces, handler);
    }
}
