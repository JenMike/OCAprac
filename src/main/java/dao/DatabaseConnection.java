package main.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import static main.java.dao.DBConfig.*;

public class DatabaseConnection {

    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(
                    CONNECTION_URL, USER_NAME, PASSWORD);
//            Statement statement = conn.createStatement();
//            ResultSet rs = statement.executeQuery(String.format("select * from %s", BOOK_TABLE));
//            while (rs.next()) {
//                System.out.println(rs.getString("Title"));
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        finally {
//            if(Objects.nonNull(conn)) {
//                try {
//                  //  conn.close();
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//            }
//        }
        return conn;
    }

//    public static void main(String[] args) {
//        System.out.println(getConnection());
//    }
}
