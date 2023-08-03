package com.ssm.mybatis.mapper;

import com.ssm.mybatis.bean.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName: CacheMapper
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/3 8:53
 * @Version 1.0
 */
public interface CacheMapper {

    /**
     * 根据员工id查询员工信息
     * @param empId
     * @return
     */
    Emp getEmpById(@Param("empId") Integer empId);
}
