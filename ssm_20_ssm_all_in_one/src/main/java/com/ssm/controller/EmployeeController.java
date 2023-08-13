package com.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.bean.Employee;
import com.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * ClassName: EmployeeController
 * Description:
 *
 * 查询所有的员工信息-->/employee-->get
 * 查询员工的分页信息-->/employee/page/1-->get
 * 根据id查询员工信息-->/employee/1-->get
 * 跳转到添加页面-->/to/add-->get
 * 添加员工信息-->/employee-->post
 * 修改员工信息-->/employee-->put
 * 删除员工信息-->/employee/1-->delete
 *
 * @Author wggglggg
 * @Create 2023/8/11 16:55
 * @Version 1.0
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model){

        //查询所有的员工信息
        List<Employee> employeeList = employeeService.getAllEmployee();
        //将员工信息在请求域中共享
        model.addAttribute("employeeList", employeeList);
        //跳转到employee_list.html
        return "employee_list";
    }

    // 查询所有员工分页
    @RequestMapping(value = "/employee/page/{pageNum}", method = RequestMethod.GET)
    public String getEmployeePage(Model model, @PathVariable("pageNum") Integer pageNum){
        PageInfo<Employee> employeePage = employeeService.getEmployeePage(pageNum);

        model.addAttribute("employeePage", employeePage);

        return "employee_list2";
    }

    // 查看某一个员工信息
    @RequestMapping(value = "/employee/{empId}", method = RequestMethod.GET)
    public String getEmployeeById(@PathVariable("empId") Integer empId, Model model){
        Employee employee = employeeService.getEmployeeById(empId);


        model.addAttribute("employee", employee);

        return "employee";
    }

    // 修改某一个员工信息
    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public String updateEmployee(Employee employee){
        employeeService.updateEmployee(employee);

        return "redirect:/employee";

    }

    @RequestMapping(value = "/add/employee", method = RequestMethod.GET)
    public String toInsert(){

        return "add_employee";
    }

    @RequestMapping(value = "/employee" , method = RequestMethod.POST)
    public String insertEmployee(Employee employee){
        employeeService.insertEmployee(employee);

        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/{empId}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("empId") Integer empId){
        employeeService.deleteEmployeeById(empId);

        return "redirect:/employee";
    }

}
