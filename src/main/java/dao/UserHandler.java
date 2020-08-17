package main.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserHandler implements UserDAO {

    @Override
    public User getUser(String username) {
        Connection conn = DatabaseConnection.getConnection();
        String sql = String.format("select * from %s where %s='%s'", USER_TABLE, COLUMN_USERNAME, username);
        User user = new User();
        try {
            PreparedStatement ps = conn
                    .prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int user_id= rs.getInt(COLUMN_UID);
                String uname = rs.getString(COLUMN_USERNAME);
                String password = rs.getString(COLUMN_PASSWORD);
                String email = rs.getString(COLUMN_EMAIL);
                user = new User(uname, password, email, user_id);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public boolean loginStatus(String username, String password){
        Connection conn = DatabaseConnection.getConnection();
        String sql = String.format("select * from %s where %s='%s' and %s='%s'", USER_TABLE, COLUMN_USERNAME, username, COLUMN_PASSWORD, password);
        PreparedStatement ps;
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                conn.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void updateUser(User user) {
        Connection conn = DatabaseConnection.getConnection();
        String sql = String.format("update %s set %s=?, %s=?, %s=?  where %s=?", USER_TABLE, COLUMN_UID, COLUMN_PASSWORD, COLUMN_EMAIL, COLUMN_USERNAME);
        try {
            PreparedStatement ps = conn
                    .prepareStatement(sql);
            ps.setInt(1, user.getUser_id());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getUsername());
            ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkUser(String username){
        Connection conn = DatabaseConnection.getConnection();
        String sql = String.format("select * from %s where %s='%s'", USER_TABLE, COLUMN_USERNAME, username);
        try {
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                conn.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void addUser(User user) {
        Connection con = DatabaseConnection.getConnection();
        String sql = String.format("insert into %s values (?,?,?,?)", USER_TABLE);
        try {
            PreparedStatement ps;
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, user.getUser_id());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail());
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
