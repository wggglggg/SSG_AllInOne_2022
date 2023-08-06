package com.ssm.spring.controller;

import com.ssm.spring.service.BookService;
import com.ssm.spring.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * ClassName: BookController
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/6 16:38
 * @Version 1.0
 */
@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BooksService booksService;

    public void buyBook(Integer userId, Integer bookId){
        bookService.buyBook(userId, bookId);
    }

    public void buyBooks(Integer userId, Integer[] bookIds){
        booksService.buyBooks(userId, bookIds);
    }
}
