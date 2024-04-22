import java.sql.*;

public class Main {
    public static void main(String[] args) throws  Exception{

//        JDBC演示
//        1.注册驱动：5之后的jar包可以省略第一步
        Class.forName("com.mysql.jdbc.Driver");

//        2,获取链接数据库对象
        String url="jdbc:mysql://127.0.0.1:3306/root1?useSSL=false";
        String username="root";
        String password="465700";
        Connection con= DriverManager.getConnection(url,username,password);

//        3,定义sql语句
        String sql="\n" +
                "UPDATE t1 \n" +
                "SET `id`=2\n" +
                "WHERE `name`='王'";

//       4 获取sql对象
        PreparedStatement pre=con.prepareStatement(sql);


        //        3,定义sql语句
        String sql1="\n" +
                "UPDATE t1 \n" +
                "SET `id`=4\n" +
                "WHERE `name`='王'";

//       4 获取sql对象
        PreparedStatement pre1=con.prepareStatement(sql1);

        int cont= 0;//执行并返回受影响行数
        int cont1=0;
        try {
            con.setAutoCommit(false);
            cont = pre.executeUpdate();


            cont1= pre1.executeUpdate();
            con.commit();



        } catch (Exception e) {
            con.rollback();

        }

        System.out.println("cont="+cont);
        System.out.println("cont1="+cont1);






//        6,关闭资源
        pre1.close();
        pre.close();
        con.close();



    }
}