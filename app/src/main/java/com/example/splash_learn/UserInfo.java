package com.example.splash_learn;

/**
 * This is userInfo class
 */
public class UserInfo {
    String user_name, password,college_name,email;

    /**
     * parameterized constructor
     * @param user_name
     * @param password
     * @param college_name
     * @param email
     */
    public UserInfo(String user_name, String password, String college_name, String email) {
        this.user_name = user_name;
        this.password = password;
        this.college_name = college_name;
        this.email = email;
    }

    /**
     * Default Constructor
     */
    public  UserInfo(){}

    /**
     * this will return name
     * @return
     */
    public  String getUser_name(){ return  user_name;}

    /**
     * This will return password
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * This will set the password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This will set username
     * @param user_name
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     * getting the college name
     * @return
     */
    public String getCollege_name() {
        return college_name;
    }

    /**
     * setting the college name
     * @param college_name
     */
    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    /**
     * this will be used to get email
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * This will be used to set email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
