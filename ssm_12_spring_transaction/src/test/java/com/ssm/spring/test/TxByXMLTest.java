package com.ssm.spring.test;

import com.ssm.spring.controller.BookController;
import com.ssm.spring.service.BooksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * ClassName: TxByXMLTest
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/6 17:12
 * @Version 1.0
 */
@SpringJUnitConfig(locations = "classpath:tx-xml.xml")
public class TxByXMLTest {
    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook(){
//        bookController.buyBook(1,1);
        bookController.buyBooks(1, new Integer[]{1, 2});
    }
}
