package main.java.dao;

public class User {
    private String username;
    private String password;
    private String email;
    private int user_id;

    public User(){}

    public User(String username, String password, String email, int user_id) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        password = newPassword;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String newEmail){
        email = newEmail;
    }

    public String getUsername() {
        return username;
    }

    public void setUserName(String newUsername) {
        username = newUsername;
    }

}
