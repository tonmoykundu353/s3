package com.example.splash_learn;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ContestentinfoTest {

    private Contestentinfo contestentinfo;

    @Before
    public void setUp() {
        contestentinfo = new Contestentinfo();
    }

    @Test
    public void testConstructorWithParameters() {
        Contestentinfo ci = new Contestentinfo("John Doe", "john.doe@example.com", "1234567890");
        assertEquals("John Doe", ci.getName());
        assertEquals("john.doe@example.com", ci.getEmail());
        assertEquals("1234567890", ci.getContactNo());
    }

    @Test
    public void testDefaultConstructor() {
        assertNotNull(contestentinfo);
    }

    @Test
    public void testSetName() {
        contestentinfo.setName("Jane Doe");
        assertEquals("Jane Doe", contestentinfo.getName());
    }

    @Test
    public void testSetEmail() {
        contestentinfo.setEmail("jane.doe@example.com");
        assertEquals("jane.doe@example.com", contestentinfo.getEmail());
    }

    @Test
    public void testSetContactNo() {
        contestentinfo.setContactNo("0987654321");
        assertEquals("0987654321", contestentinfo.getContactNo());
    }

    @Test
    public void testSetNameEmpty() {
        contestentinfo.setName("");
        assertEquals("", contestentinfo.getName());
    }

    @Test
    public void testSetEmailEmpty() {
        contestentinfo.setEmail("");
        assertEquals("", contestentinfo.getEmail());
    }

    @Test
    public void testSetContactNoEmpty() {
        contestentinfo.setContactNo("");
        assertEquals("", contestentinfo.getContactNo());
    }

    @Test
    public void testConstructorWithEmptyParameters() {
        Contestentinfo ci = new Contestentinfo("", "", "");
        assertEquals("", ci.getName());
        assertEquals("", ci.getEmail());
        assertEquals("", ci.getContactNo());
    }
}
