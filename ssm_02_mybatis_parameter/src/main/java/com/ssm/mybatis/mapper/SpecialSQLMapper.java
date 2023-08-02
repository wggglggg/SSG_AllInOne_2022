package com.ssm.mybatis.mapper;

import com.ssm.mybatis.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName: SpecialSQLMapper
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/2 11:11
 * @Version 1.0
 */
public interface SpecialSQLMapper {

    /**
     * 模糊查询 Like查询
     * @param fuzzyLike
     * @return
     */
    List<User> getUserByLike(@Param("fuzzyLike") String fuzzyLike);

    /**
     * 批量删除
     * @param ids
     */
    void deleteMoreUser(@Param("ids") String ids);

    /**
     * 动态设置表名，查询用户信息
     * @param tableName
     * @return
     */
    List<User> getUserList(@Param("tableName") String tableName);

    /**
     * 添加用户信息并获取自增的主键
     * @param user
     */
    void insertUser(User user);
}
