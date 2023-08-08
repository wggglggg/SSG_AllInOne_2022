package com.ssm.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * ClassName: TestScopeController
 * Description:
 * 向域对象共享数据：
 * 1、通过ModelAndView向请求域共享数据
 * 使用ModelAndView时，可以使用其Model功能向请求域共享数据
 * 使用View功能设置逻辑视图，但是控制器方法一定要将ModelAndView作为方法的返回值
 * 2、使用Model向请求域共享数据
 * 3、使用ModelMap向请求域共享数据
 * 4、使用map向请求域共享数据
 * 5、Model和ModelMap和map的关系
 * 其实在底层中，这些类型的形参最终都是通过BindingAwareModelMap创建
 * public class BindingAwareModelMap extends ExtendedModelMap {}
 * public class ExtendedModelMap extends ModelMap implements Model {}
 * public class ModelMap extends LinkedHashMap<String, Object> {}
 * @Author wggglggg
 * @Create 2023/8/8 8:26
 * @Version 1.0
 */
@Controller
public class TestScopeController {

    //此方法不推荐,下面几种 更方便快捷
    @RequestMapping("/test/servletAPI")
    public String testServletAPI(HttpServletRequest request){
        request.setAttribute("bba", "宝马奔驰奥迪");

        return "success";
    }

    //方式一 ModelAndVie共享数据
    @RequestMapping("/test/mav")
    public ModelAndView testMAV(){
        /**
         * ModelAndView包含Model和View的功能
         * Model：向请求域中共享数据
         * View：设置逻辑视图实现页面跳转
         */
        ModelAndView modelAndView = new ModelAndView();
        //向请求域中共享数据
        modelAndView.addObject("air_con", "空调");
        //设置逻辑视图
        modelAndView.setViewName("success");

        return modelAndView;
    }

    //方式二 Model共享数据
    @RequestMapping("/test/model")
    public String testModel(Model model){
        model.addAttribute("Television", "电视机");

        return "success";
    }

    // 方式三 ModelMap共享数据
    @RequestMapping("/test/modelMap")
    public String testModelMap(ModelMap modelMap) {
        modelMap.addAttribute("PC", "电脑");

        return "success";
    }

    //方式四 Map共享数据
    @RequestMapping("/test/map")
    public String testMap(Map<String, Object> map){
        map.put("summer", "夏天");

        return "success";
    }

    //方式五 向session共享数据
    @RequestMapping("/test/session")
    public String testSession(HttpSession session){
        session.setAttribute("Fan", "风扇");

        return "success";
    }

    //方式六 向application应用域共享数据
    @RequestMapping("/test/application")
    public String testApplication(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("deliver", "外卖小哥");

        return "success";
    }
}
