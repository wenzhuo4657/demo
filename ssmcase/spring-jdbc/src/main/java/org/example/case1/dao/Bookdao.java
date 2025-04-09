package org.example.case1.dao;

public interface Bookdao {
    Integer getPriceByBookId(Integer bookId);
    void updateStock(Integer bookId);
    void updateBalance(Integer userId, Integer price);
}
