package org.example.case1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class checkoutImpl implements checkout{
    @Autowired
    BookserviceImpl bookservice;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void check(Integer[] books, Integer userId) {
        for(int i:books){
            bookservice.buyBook(i,userId);
        }
    }
}
