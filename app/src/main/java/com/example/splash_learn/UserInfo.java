package com.example.splash_learn;

public class UserInfo {
    String user_name, password,college_name,email;

    public UserInfo(String user_name, String password, String college_name, String email) {
        this.user_name = user_name;
        this.password = password;
        this.college_name = college_name;
        this.email = email;
    }
    public  UserInfo(){}
    public  String getUser_name(){ return  user_name;}
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
