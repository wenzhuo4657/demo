package com;

import java.sql.*;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

/**
 * @className: test
 * @author: wenzhuo4657
 * @date: 2024/4/11 15:59
 * @Version: 1.0
 * @description:
 */

    public  class JDbcTest{
        public static void success(){
            System.out.println("success");
        }
        public static void dad(){
            System.out.println("dad");
        }

    public static void main(String[] args) {
        try {

            java.lang.Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://127.0.0.1:3307/root1";
            Connection connection = DriverManager.getConnection(url,"root","465700");
            if (Objects.isNull(connection))
               dad();
            Scanner scanner=new Scanner(System.in);
            System.out.println("等待输入----");
            String str=scanner.next();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(str);
            while (resultSet.next()){
                System.out.println("id:"+resultSet.getInt(1)+
                        "\nname:"+resultSet.getString(2)+
                        "\npass:"+resultSet.getString("pass"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("你錯了");;
        }
    }


}
