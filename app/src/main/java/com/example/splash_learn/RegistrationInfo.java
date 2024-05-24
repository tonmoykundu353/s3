package com.example.splash_learn;

/**
 * This is RegistrationInfo class
 */
public class RegistrationInfo {
    String Uni_name,Uni_roll,Uni_password;

    /**
     * This will be parameterized Constructor
     * @param uni_name
     * @param uni_roll
     * @param uni_password
     */
    public RegistrationInfo(String uni_name, String uni_roll, String uni_password) {
        Uni_name = uni_name;
        Uni_roll = uni_roll;
        Uni_password = uni_password;
    }

    /**
     * This is the default constructor
     */
    public RegistrationInfo() {

    }

    /**
     * This will be used to get name
     * @return
     */
    public String getUni_name() {
        return Uni_name;
    }

    /**
     * This will be used to set university name
     * @param uni_name
     */
    public void setUni_name(String uni_name) {
        Uni_name = uni_name;
    }

    /**
     * This will be used to get uni roll
     * @return
     */
    public String getUni_roll() {
        return Uni_roll;
    }

    /**
     * This will be used to set uni roll
     * @param uni_roll
     */
    public void setUni_roll(String uni_roll) {
        Uni_roll = uni_roll;
    }

    /**
     * This will be used to get University password
     * @return
     */
    public String getUni_password() {
        return Uni_password;
    }

    /**
     * This will be used to set university password
     * @param uni_password
     */
    public void setUni_password(String uni_password) {
        Uni_password = uni_password;
    }
}
