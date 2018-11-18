package cn.shen.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author shen
 */
public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///mybatis";
        String username = "root";
        String password = "1998";
        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = "select * from tb_user where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1,1L);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString("user_name"));
            System.out.println(resultSet.getString("password"));
            System.out.println(resultSet.getString("name"));

        }

    }
}
