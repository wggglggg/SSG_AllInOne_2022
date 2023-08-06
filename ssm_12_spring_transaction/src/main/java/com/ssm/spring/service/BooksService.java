package com.ssm.spring.service;

/**
 * ClassName: BooksService
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/6 16:49
 * @Version 1.0
 */
public interface BooksService {

    void buyBooks(Integer userId, Integer[] bookIds);
}
