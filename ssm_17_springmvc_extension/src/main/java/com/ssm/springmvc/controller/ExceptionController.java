package com.ssm.springmvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * ClassName: ExceptionController
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/10 17:22
 * @Version 1.0
 */
//将当前类标识为异常处理的组件
@ControllerAdvice
public class ExceptionController {

    //设置要处理的异常信息
    @ExceptionHandler(ArithmeticException.class)
    public String handleException(Model model, Throwable ex){

        model.addAttribute("ex", ex);

        return "zero_error";
    }


}
