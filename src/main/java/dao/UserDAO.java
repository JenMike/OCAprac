package main.java.dao;

public interface UserDAO {
    static String USER_TABLE = "UserTest";
    static String COLUMN_UID = "id";
    static String COLUMN_USERNAME = "username";
    static String COLUMN_PASSWORD = "password";
    static String COLUMN_EMAIL = "email";

    void addUser(User user);

    boolean checkUser(String username);

    boolean loginStatus(String username, String password);

    void updateUser(User user);

    User getUser(String username);

}