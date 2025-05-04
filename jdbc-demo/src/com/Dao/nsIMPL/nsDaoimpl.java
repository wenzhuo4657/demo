//package com.Dao.nsIMPL;
//import  com.Dao.nsdao;
//import com.Entity.ns;
//import com.utils.Dbutil;
//import org.apache.commons.dbutils.QueryRunner;
//import org.apache.commons.dbutils.handlers.BeanHandler;
//import org.apache.commons.dbutils.handlers.BeanListHandler;
//
//import java.sql.SQLException;
//import java.util.List;
//
//public class nsDaoimpl  implements  nsdao{
//
//    private static final QueryRunner query=new QueryRunner(Dbutil.getDat());
//
//    @Override
//    public int insert(ns useer) {
//        Object[] pa={useer.getUser(),useer.getId(),useer.getPassword(),useer.getPhone(),useer.getAddress()};
//
//        try {
//
//            int result= query.update("insert into  ns(`user`,id,password,phone,address)  values (?,?,?,?,?);",pa);
//            return result;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    @Override
//    public int update(ns useer) {
//        return 0;
//    }
//
//    @Override
//    public int delete(int id) {
//        return 0;
//    }
//
//    @Override
//    public ns select(int id) {
//        try {
//
//            return  query.query("select*from ns where id=?;",new BeanHandler<com.Entity.ns>(com.Entity.ns.class),id);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    @Override
//    public List<ns> slect() {
//        try {
//            return  query.query("select*from ns",new BeanListHandler<ns>(ns.class));
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
