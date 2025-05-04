package com.Dao;
import  com.Entity.ns;

import java.util.List;

public interface nsdao {

    public int insert (ns useer);
    public int update(ns useer);
    public  int delete(int id);
    public  ns select(int id);
    public List<ns>  slect();

}
