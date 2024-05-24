package com.example.splash_learn;
//
//public class Contestentinfo {
//    String name,email,collegename;
//
//    public Contestentinfo(String name, String email, String collegename) {
//        this.name = name;
//        this.email = email;
//        this.collegename = collegename;
//    }
//
//    public Contestentinfo() {
//
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getCollegename() {
//        return collegename;
//    }
//
//    public void setCollegename(String collegename) {
//

/**
 * This is Contestentinfo class for having the names ,emails and contactNo
 */

public class Contestentinfo {
    String name,email,ContactNo;

    /**
     * Paramterized Constructor added
     * @param name
     * @param email
     * @param ContactNo
     */
    public Contestentinfo(String name, String email, String ContactNo) {
        this.name = name;
        this.email = email;
        this.ContactNo = ContactNo;
    }

    /**
     * Default Constructor
     */
    public Contestentinfo() {

    }

    /**
     * This will get name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * this will used to set name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This will used to get email
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * This will used to set email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This will get contact info
     * @return
     */
    public String getContactNo() {
        return ContactNo;
    }

    /**
     * This will be used to set contactNo
     * @param ContactNo
     */
    public void setContactNo(String ContactNo) {
        this.ContactNo = ContactNo;
    }
}
