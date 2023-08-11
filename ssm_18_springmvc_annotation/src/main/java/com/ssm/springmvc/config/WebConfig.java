package com.ssm.springmvc.config;

import com.ssm.springmvc.interceptor.FirstInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.util.List;
import java.util.Properties;

/**
 * ClassName: WebConfig
 * Description:
 *
 * 代替SpringMVC的配置文件
 * 扫描组件、视图解析器、默认的servlet、mvc的注解驱动
 * 视图控制器、文件上传解析器、拦截器、异常解析器
 *
 * @Author wggglggg
 * @Create 2023/8/10 19:36
 * @Version 1.0
 */
@Configuration                      //将类标识为配置类
@ComponentScan("com.ssm.springmvc") //扫描组件
@EnableWebMvc                       //开启mvc的注解驱动
public class WebConfig implements WebMvcConfigurer {


    //默认的servlet处理静态资源
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //配置视图解析器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    // 添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        FirstInterceptor firstInterceptor = new FirstInterceptor();
        registry.addInterceptor(firstInterceptor).addPathPatterns("/**");
    }

    //配置异常解析器
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();

        Properties properties = new Properties();
        properties.setProperty("java.lang.ArithmeticException", "zero_error");

        exceptionResolver.setExceptionMappings(properties);
        exceptionResolver.setExceptionAttribute("ex");
        resolvers.add(exceptionResolver);
    }

    //@Bean注解可以将标识的方法的返回值作为bean进行管理，bean的id为方法的方法名;配置文件上传解析器
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        return new CommonsMultipartResolver();
    }


    /**
     *              配置Thymeleaf视图解析器
     * <bean id="viewResolver" class="org.thymeleaf.spring5.view.ThymeleafViewResolver">
     *         <property name="order" value="1"/>
     *         <property name="characterEncoding" value="UTF-8"/>
     *         <property name="templateEngine">
     *             <bean class="org.thymeleaf.spring5.SpringTemplateEngine">
     *                 <property name="templateResolver">
     *                     <bean class="org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver">
     *                         <!-- 视图前缀 -->
     *                         <property name="prefix" value="/WEB-INF/templates/"/>
     *                         <!-- 视图后缀 -->
     *                         <property name="suffix" value=".html"/>
     *                         <property name="templateMode" value="HTML5"/>
     *                         <property name="characterEncoding" value="UTF-8" />
     *                     </bean>
     *                 </property>
     *             </bean>
     *         </property>
     *     </bean>
     */

    // 生成视图解析器并未解析器注入模板引擎
    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setOrder(1);
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setTemplateEngine(templateEngine);

        return viewResolver;
    }

    //生成模板引擎并为模板引擎注入模板解析器
    @Bean
    public SpringTemplateEngine springTemplateEngine(ITemplateResolver templateResolver){
        SpringTemplateEngine TemplateEngine = new SpringTemplateEngine();
        TemplateEngine.setTemplateResolver(templateResolver);

        return TemplateEngine;
    }

    //配置生成模板解析器
    @Bean
    public ITemplateResolver templateResolver(){
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        // ServletContextTemplateResolver需要一个ServletContext作为构造参数，可通过WebApplicationContext 的方法获得
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(
                webApplicationContext.getServletContext());

        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");

        return templateResolver;

    }




}
