package com.example.splash_learn;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RegistrationInfoTest {

    private RegistrationInfo registrationInfo;

    @Before
    public void setUp() {
        registrationInfo = new RegistrationInfo();
    }

    @Test
    public void testSetAndGetUni_name() {
        registrationInfo.setUni_name("Harvard University");
        assertEquals("Harvard University", registrationInfo.getUni_name());
    }

    @Test
    public void testSetAndGetUni_roll() {
        registrationInfo.setUni_roll("123456");
        assertEquals("123456", registrationInfo.getUni_roll());
    }

    @Test
    public void testSetAndGetUni_password() {
        registrationInfo.setUni_password("password123");
        assertEquals("password123", registrationInfo.getUni_password());
    }

    @Test
    public void testSetAndGetUni_nameEmpty() {
        registrationInfo.setUni_name("");
        assertEquals("", registrationInfo.getUni_name());
    }

    @Test
    public void testSetAndGetUni_rollEmpty() {
        registrationInfo.setUni_roll("");
        assertEquals("", registrationInfo.getUni_roll());
    }

    @Test
    public void testSetAndGetUni_passwordEmpty() {
        registrationInfo.setUni_password("");
        assertEquals("", registrationInfo.getUni_password());
    }

    @Test
    public void testSetAndGetUni_nameNull() {
        registrationInfo.setUni_name(null);
        assertNull(registrationInfo.getUni_name());
    }

    @Test
    public void testSetAndGetUni_rollNull() {
        registrationInfo.setUni_roll(null);
        assertNull(registrationInfo.getUni_roll());
    }

    @Test
    public void testSetAndGetUni_passwordNull() {
        registrationInfo.setUni_password(null);
        assertNull(registrationInfo.getUni_password());
    }
}
