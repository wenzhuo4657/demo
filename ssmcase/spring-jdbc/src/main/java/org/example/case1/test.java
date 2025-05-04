package org.example.case1;


import org.example.case1.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;


@SpringJUnitConfig(locations = "classpath:beans.xml")
public class test {

        @Autowired
    private BookController bookController;
    @Test
    public void testBuyBook(){

        Integer[] boo={1,2,3};
        bookController.buyBook(1, 1);
    }







}
