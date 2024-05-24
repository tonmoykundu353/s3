package com.example.splash_learn;

public class RegistrationInfo {
    String Uni_name,Uni_roll,Uni_password;

    public RegistrationInfo(String uni_name, String uni_roll, String uni_password) {
        Uni_name = uni_name;
        Uni_roll = uni_roll;
        Uni_password = uni_password;
    }

    public RegistrationInfo() {

    }

    public String getUni_name() {
        return Uni_name;
    }

    public void setUni_name(String uni_name) {
        Uni_name = uni_name;
    }

    public String getUni_roll() {
        return Uni_roll;
    }

    public void setUni_roll(String uni_roll) {
        Uni_roll = uni_roll;
    }

    public String getUni_password() {
        return Uni_password;
    }

    public void setUni_password(String uni_password) {
        Uni_password = uni_password;
    }
}
