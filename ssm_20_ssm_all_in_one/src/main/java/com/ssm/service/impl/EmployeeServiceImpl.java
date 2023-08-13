package com.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.bean.Employee;
import com.ssm.mapper.EmployeeMapper;
import com.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName: EmployeeServiceImpl
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/12 21:09
 * @Version 1.0
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    @Override
    public PageInfo<Employee> getEmployeePage(Integer pageNum) {
        PageHelper.startPage(pageNum, 4);

        List<Employee> employeeList = employeeMapper.getAllEmployee();

        PageInfo<Employee> employeePageInfo = new PageInfo<>(employeeList, 3);

        return employeePageInfo;
    }

    @Override
    public Employee getEmployeeById(Integer empId) {
        return employeeMapper.get(empId);
    }

    @Override
    public void updateEmployee(Employee employee) {

        employeeMapper.save(employee);
    }

    @Override
    public void insertEmployee(Employee employee) {
        employeeMapper.insert(employee);
    }

    @Override
    public void deleteEmployeeById(Integer empId) {
        employeeMapper.delete(empId);
    }
}
