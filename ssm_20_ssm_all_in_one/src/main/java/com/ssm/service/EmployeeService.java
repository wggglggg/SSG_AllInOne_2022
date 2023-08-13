package com.ssm.service;

import com.github.pagehelper.PageInfo;
import com.ssm.bean.Employee;

import java.util.List;

/**
 * ClassName: EmployeeService
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/12 21:09
 * @Version 1.0
 */
public interface EmployeeService {

    /**
     * 查询所有的员工信息
     * @return
     */
    List<Employee> getAllEmployee();

    /**
     * 蓝底所有员工带分页
     * @param pageNum
     * @return
     */
    PageInfo<Employee> getEmployeePage(Integer pageNum);

    /**
     * 查询某个用户
     * @param empId
     * @return
     */
    Employee getEmployeeById(Integer empId);

    /**
     * 修改用户信息
     * @param employee
     */
    void updateEmployee(Employee employee);

    /**
     * 增加user员工
     * @param employee
     */
   void insertEmployee(Employee employee);

    /**
     * 按Id来删除某位员工
     * @param empId
     */
   void deleteEmployeeById(Integer empId);
}
