package com.ssm.spring.service.impl;

import com.ssm.spring.service.BookService;
import com.ssm.spring.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName: BooksService
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/6 16:48
 * @Version 1.0
 */
@Service
//@Transactional
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BookService bookService;
    @Override
    public void buyBooks(Integer userId, Integer[] bookIds) {
        for (Integer bookId : bookIds){
            bookService.buyBook(userId, bookId);
        }
    }
}
