package com.ssm.spring.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * ClassName: DataSourceTest
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/4 13:24
 * @Version 1.0
 */
public class DataSourceTest {
    
    @Test
    public void testDataSource() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-datasource.xml");
        DruidDataSource dataSource = context.getBean(DruidDataSource.class);
        System.out.println(dataSource.getConnection());

    }
}
