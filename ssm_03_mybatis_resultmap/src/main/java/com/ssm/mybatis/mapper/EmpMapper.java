package com.ssm.mybatis.mapper;

import com.ssm.mybatis.bean.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName: EmpMapper
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/2 14:58
 * @Version 1.0
 */
public interface EmpMapper {
    /**
     * 根据id查询员工信息
     * @param empId
     * @return
     */
    Emp getEmpByEmpId(@Param("empId") int empId);

    /**
     * 获取员工 以及  所对应的部门信息
     * @param empId
     * @return
     */
    Emp getEmpAndDeptByEmpId(@Param("empId")  int empId);

    /**
     * 通过分步查询查询员工以及所对应的部门信息第一步,联系DeptMapper.java
     * @param empId
     * @return
     */
    Emp getEmpAndDeptByStepOne(@Param("empId") int empId);

    /**
     * 通过分步查询查询部门以及部门中的员工信息第二步, 从DeptMapper.java查询来
     * @param deptId
     * @return
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("deptId") int deptId);
}
