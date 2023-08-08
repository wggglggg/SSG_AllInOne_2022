package com.ssm.springmvc.controller;

import com.ssm.springmvc.DAO.EmployeeDAO;
import com.ssm.springmvc.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Method;
import java.util.Collection;

/**
 * ClassName: EmployeeController
 * Description:
 *
 * 访问首页√             / GET
 * 查询全部数据√          / employee GET
 * 删除√                 / employee/2 DELETE
 * 跳转到添加数据页面√     / toAdd GET
 * 执行保存√             / employee POST
 * 跳转到更新数据页面√     / employee/2 GET
 * 执行更新√             / employee PUT
 *
 * @Author wggglggg
 * @Create 2023/8/8 16:19
 * @Version 1.0
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    // 显示所有员工
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        //获取所有的员工信息
        Collection<Employee> allEmployee = employeeDAO.getAll();
        //将所有的员工信息在请求域中共享
        model.addAttribute("allEmployee", allEmployee);
        //跳转到列表页面
        return "employees";
    }


    //添加新员工
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String insertEmployee(Employee employee){
        //保存员工信息
        employeeDAO.save(employee);
        //重定向到列表功能：/employee
        return "redirect:/employees";
    }

    // 显示修改员工页面
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id, Model model){
        //根据id查询员工信息
        Employee employee = employeeDAO.get(id);
        //将员工信息共享到请求域中
        model.addAttribute("employee", employee);
        //跳转到employee_update.html
        return "employee_update";
    }

    // 修改员工信息
    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public String updateEmployee(Employee employee){
        //修改员工信息
        employeeDAO.save(employee);

        //重定向到列表功能：/employees
        return "redirect:/employees";
    }

    // 删除某员工
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        //删除员工信息
        employeeDAO.delete(id);
        //重定向到列表功能：/employees
        return "redirect:/employees";
    }
}
