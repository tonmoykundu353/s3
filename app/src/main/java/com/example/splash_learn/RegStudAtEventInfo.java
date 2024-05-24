package com.example.splash_learn;

public class RegStudAtEventInfo {
    String contactNo,email,name;

    public RegStudAtEventInfo(String contactNo, String email, String name) {
        this.contactNo = contactNo;
        this.email = email;
        this.name = name;
    }

    public RegStudAtEventInfo() {

    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
