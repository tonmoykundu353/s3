package com.example.splash_learn;

import static org.junit.Assert.*;
import org.junit.Test;

public class UserInfoTest {

    @Test
    public void testEmptyStrings() {
        UserInfo userInfo = new UserInfo();

        // Set empty strings
        userInfo.setUser_name("");
        userInfo.setPassword("");
        userInfo.setCollege_name("");
        userInfo.setEmail("");

        // Check if the getter methods return empty strings
        assertEquals("", userInfo.getUser_name());
        assertEquals("", userInfo.getPassword());
        assertEquals("", userInfo.getCollege_name());
        assertEquals("", userInfo.getEmail());
    }

    @Test
    public void testNonEmptyStrings() {
        UserInfo userInfo = new UserInfo("username", "password", "college", "email@example.com");

        // Check if the getter methods return the correct values
        assertEquals("username", userInfo.getUser_name());
        assertEquals("password", userInfo.getPassword());
        assertEquals("college", userInfo.getCollege_name());
        assertEquals("email@example.com", userInfo.getEmail());
    }
}
