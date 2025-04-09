//package com.utils;
//
//import com.alibaba.druid.pool.DruidDataSourceFactory;
//import com.mysql.jdbc.Statement;
//
//import javax.sql.DataSource;
//import java.io.FileInputStream;
//import java.io.InputStream;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Properties;
//
//public class Dbutil {
//    private  static  final Properties  PROPERTIES=new Properties();
//    private  static  final  ThreadLocal<Connection>  th=new ThreadLocal<>();//存储线程当前事务
//    private static final   DataSource Dat;//数据库连接池
//
//
//
//
////创建数据库连接池
//     static  {
//
//
//             try {
//                 PROPERTIES.load(new FileInputStream("src/druid.properties"));
//                Dat= DruidDataSourceFactory.createDataSource(PROPERTIES);
//             } catch (Exception e) {
//                 throw new RuntimeException(e);
//             }
//
//     }
//
//
//
//     public static Connection getConection() throws SQLException {
//         Connection con= th.get();//有则返回，没有则返回null
//         if (con==null){
//             con=Dat.getConnection();
//             th.set(con);
//         }
//
//         return  con;
//     }
//
////     开启事务
//     public  static   void begin(){
//         Connection con=null;
//         try {
//             con=getConection();
//             con.setAutoCommit(false);
//         } catch (SQLException e) {
//             throw new RuntimeException(e);
//         }
//
//     }
//
//
//     //提交事务
//     public  static  void commit(){
//         Connection con=null;
//
//         try {
//             con=getConection();
//             con.commit();
//         } catch (SQLException e) {
//             throw new RuntimeException(e);
//         }
//     }
//
////     回滚事务
//    public  static  void rollback(){
//         Connection con=null;
//        try {
//            con=getConection();
//            con.rollback();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//
////    关闭资源
//    public  static  void colseAll(Connection con, Statement Sta, ResultSet Res){
//        try {
//            if (Res!=null){
//                Res.close();
//            }
//
//            if (Sta!=null){
//                Sta.close();
//            }
//
//            if (con!=null){
//                con.close();
//                th.remove();
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    public  static  DataSource getDat(){
//        return  Dat;
//    }
//
//
//
//
//
//}
