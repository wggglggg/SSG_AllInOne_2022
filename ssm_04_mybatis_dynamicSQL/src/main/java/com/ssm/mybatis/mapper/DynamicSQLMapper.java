package com.ssm.mybatis.mapper;

import com.ssm.mybatis.bean.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName: DynamicSQLMapper
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/2 20:46
 * @Version 1.0
 */
public interface DynamicSQLMapper {

    /**
     * 根据条件查询员工信息
     * @param emp
     * @return
     */
    List<Emp> getEmpByCondition(Emp emp);

    /**
     * 使用choose查询员工信息
     * @param emp
     * @return
     */
    List<Emp> getEmpByChoose(Emp emp);

    /**
     * 批量添加员工信息
     * @param empList
     */
    void insertMoreEmp(@Param("empList") List<Emp> empList);

    /**
     * 批量删除员工信息
     * @param empIds
     */
    void deleteMoreEmp(@Param("empIds") List<Integer> empIds);


}
