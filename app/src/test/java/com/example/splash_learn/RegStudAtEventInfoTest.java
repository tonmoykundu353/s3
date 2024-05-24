package com.example.splash_learn;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RegStudAtEventInfoTest {

    private RegStudAtEventInfo regStudAtEventInfo;

    @Before
    public void setUp() {
        regStudAtEventInfo = new RegStudAtEventInfo();
    }

    @Test
    public void testConstructorWithParameters() {
        RegStudAtEventInfo info = new RegStudAtEventInfo("1234567890", "test@example.com", "John Doe");
        assertEquals("1234567890", info.getContactNo());
        assertEquals("test@example.com", info.getEmail());
        assertEquals("John Doe", info.getName());
    }

    @Test
    public void testDefaultConstructor() {
        assertNotNull(regStudAtEventInfo);
    }

    @Test
    public void testSetAndGetContactNo() {
        regStudAtEventInfo.setContactNo("0987654321");
        assertEquals("0987654321", regStudAtEventInfo.getContactNo());
    }

    @Test
    public void testSetAndGetEmail() {
        regStudAtEventInfo.setEmail("user@example.com");
        assertEquals("user@example.com", regStudAtEventInfo.getEmail());
    }

    @Test
    public void testSetAndGetName() {
        regStudAtEventInfo.setName("Jane Doe");
        assertEquals("Jane Doe", regStudAtEventInfo.getName());
    }
}
