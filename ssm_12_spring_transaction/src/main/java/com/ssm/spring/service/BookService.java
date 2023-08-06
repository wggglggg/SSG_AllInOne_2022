package com.ssm.spring.service;

import com.ssm.spring.dao.BookDAO;

/**
 * ClassName: BookService
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/6 16:28
 * @Version 1.0
 */
public interface BookService {

    void buyBook(Integer userId, Integer bookId);

}
