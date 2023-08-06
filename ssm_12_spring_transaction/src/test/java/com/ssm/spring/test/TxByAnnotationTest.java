package com.ssm.spring.test;

import com.ssm.spring.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * ClassName: TxByAnnotationTest
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/6 16:39
 * @Version 1.0
 */
@SpringJUnitConfig(locations = "classpath:tx-annotation.xml")
public class TxByAnnotationTest {

    @Autowired
    private BookController bookController;
    @Test
    public void testTxByAnnotation(){
//        bookController.buyBook(1, 1);
//        bookController.buyBook(1, 2);

        bookController.buyBooks(1, new Integer[]{1, 2});
    }
}
