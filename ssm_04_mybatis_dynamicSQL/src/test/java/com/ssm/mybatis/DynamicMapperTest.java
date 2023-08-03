package com.ssm.mybatis;

import com.ssm.mybatis.bean.Emp;
import com.ssm.mybatis.mapper.DynamicSQLMapper;
import com.ssm.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: DynamicMapperTest
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/2 20:55
 * @Version 1.0
 */
public class DynamicMapperTest {

    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null, "李四", 21, "男");
        List<Emp> empList = mapper.getEmpByCondition(emp);
        empList.forEach(System.out::println);
    }

    @Test
    public void testGetEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null, "", 22, "男");
        List<Emp> empList = mapper.getEmpByChoose(emp);
        empList.forEach(System.out::println);
    }

    @Test
    public void testInsertMoreEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> empList = new ArrayList<>();
        empList.add(new Emp(null, "叶倩文", 60, "f"));
        empList.add(new Emp(null, "叶玉卿", 60, "f"));
        empList.add(new Emp(null, "黄乙玲", 55, "f"));

        mapper.insertMoreEmp(empList);
    }

    @Test
    public void testDeleteMoreEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Integer> empIds = new ArrayList<>();
        empIds.add(6);
        empIds.add(7);

        mapper.deleteMoreEmp(empIds);
    }
}
