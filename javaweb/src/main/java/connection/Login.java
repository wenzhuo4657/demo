package connection;

import java.sql.*;
import java.util.Optional;

/**
 * @className: login
 * @author: wenzhuo4657
 * @date: 2024/4/16 15:52
 * @Version: 1.0
 * @description:
 */


public class Login {
    static Connection connection;

    static {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3307/root1";
            connection = DriverManager.getConnection(url, "root", "465700");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String SelectOn_passwoed(String username) {
        String result = "";
        try {
            String str = "select  * from  loginUser where  username=" + username;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            while (resultSet.next()) {
                result += resultSet.getString(1);
            }
            exit(Optional.of(resultSet), Optional.of(statement));
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }


    public static void insertUser(String username, String password) {
        Statement statement = null;
        try {
            String str = "insert into   loginUser values (" + username + "," + password + ")";
            connection.createStatement();
            statement.executeQuery(str);
        } catch (Exception e) {
            System.out.println("e");
        }
        exit(null, Optional.of(statement));

    }

    public static void exit(Optional<ResultSet> resultSet, Optional<Statement> statement) {
        resultSet.ifPresent(resultSet1 -> {
            try {
                resultSet1.close();
            } catch (SQLException e) {
                System.out.println("resultSet关闭异常！！");
                throw new RuntimeException(e);
            }
        });
        statement.ifPresent(statement1 -> {
            try {
                statement1.close();
            } catch (SQLException e) {
                System.out.println("statement关闭异常！！");
                throw new RuntimeException(e);
            }
        });
    }

    public static  void select(){


    }

    public static void exitJdbcConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("jdbc连接对象关闭异常！！");
            throw new RuntimeException(e);
        }
    }
}