package org.example.case1.controller;


import org.example.case1.service.Bookservic;
import org.example.case1.service.BookserviceImpl;
import org.example.case1.service.checkoutImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Controller
public class BookController {
    @Autowired
    private BookserviceImpl checkout;
    public void buyBook(Integer bookId, Integer userId){
        checkout.buyBook(bookId, userId);
    }
}
