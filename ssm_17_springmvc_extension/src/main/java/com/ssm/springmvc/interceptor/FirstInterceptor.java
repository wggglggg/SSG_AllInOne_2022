package com.ssm.springmvc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: FirstInterceptor
 * Description:
 *
 * 拦截器的三个方法：
 * preHandle()：在控制器方法执行之前执行，其返回值表示对控制器方法的拦截(false)或放行(true)
 * postHandle()：在控制器方法执行之后执行
 * afterCompletion()：在控制器方法执行之后，且渲染视图完毕之后执行
 *
 * 多个拦截器的执行顺序和在SpringMVC的配置文件中配置的顺序有关
 * preHandle()按照配置的顺序执行，而postHandle()和afterCompletion()按照配置的反序执行
 *
 * 若拦截器中有某个拦截器的preHandle()返回了false
 * 拦截器的preHandle()返回false和它之前的拦截器的preHandle()都会执行
 * 所有的拦截器的postHandle()都不执行
 * 拦截器的preHandle()返回false之前的拦截器的afterCompletion()会执行
 *
 * @Author wggglggg
 * @Create 2023/8/10 15:31
 * @Version 1.0
 */
public class FirstInterceptor implements HandlerInterceptor {

    // false时,返回给浏览器空白,为true时, 放行 ,正常返回给浏览器在信息
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("FirstInterceptor-->preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        System.out.println("FirstInterceptor-->postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        System.out.println("FirstInterceptor-->afterCompletion");
    }
}
