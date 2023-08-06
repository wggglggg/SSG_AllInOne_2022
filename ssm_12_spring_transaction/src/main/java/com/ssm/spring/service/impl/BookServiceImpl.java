package com.ssm.spring.service.impl;

import com.ssm.spring.dao.BookDAO;
import com.ssm.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * ClassName: BookServiceImpl
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/6 16:27
 * @Version 1.0
 */
@Service
//@Transactional(propagation = Propagation.REQUIRES_NEW)
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;
    @Override
    public void buyBook(Integer userId, Integer bookId) {

        Integer price = bookDAO.getPriceByBookId(bookId);

        bookDAO.updateStock(bookId);

        bookDAO.updateBalance(userId, price);
    }

}
