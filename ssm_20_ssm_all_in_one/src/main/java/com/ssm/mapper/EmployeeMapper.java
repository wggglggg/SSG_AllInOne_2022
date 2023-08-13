package com.ssm.mapper;

import com.ssm.bean.Employee;

import java.util.List;

/**
 * ClassName: EmployeeMapper
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/11 21:48
 * @Version 1.0
 */
public interface EmployeeMapper {
    /**
     * 查询所有的员工信息
     * @return
     */
    List<Employee> getAllEmployee();

    /**
     * 查询某个员工信息
     * @param empId
     * @return
     */
    Employee get(Integer empId);

    /**
     * 修改用户
     * @param employee
     */
    void save(Employee employee);

    /**
     * 增加新员工
     *
     * @param employee
     * @return
     */
    void insert(Employee employee);

    /**
     * 删除某个员工
     * @param empId
     */
    void delete(Integer empId);
}
