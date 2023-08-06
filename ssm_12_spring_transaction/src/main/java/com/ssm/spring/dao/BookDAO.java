package com.ssm.spring.dao;

/**
 * ClassName: BookDAO
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/6 16:24
 * @Version 1.0
 */
public interface BookDAO {

    Integer getPriceByBookId(Integer bookId);

    void updateStock(Integer bookId);

    void updateBalance(Integer userId, Integer price);
}
