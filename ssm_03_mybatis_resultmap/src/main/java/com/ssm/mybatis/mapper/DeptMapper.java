package com.ssm.mybatis.mapper;

import com.ssm.mybatis.bean.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName: DeptMapper
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/2 14:58
 * @Version 1.0
 */
public interface DeptMapper {

    /**
     * 通过分步查询查询员工以及所对应的部门信息第二步
     * @param deptId
     * @return
     */
    Dept  getEmpAndDeptByStepTwo(@Param("deptId") Integer deptId);


    /**
     * 通过分步查询查询部门以及部门中的员工信息的第一步
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByStepOne(@Param("deptId") Integer deptId);

    /**
     * 查询部门以及部门中的员工信息
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpResult(@Param("deptId") Integer deptId);
}
