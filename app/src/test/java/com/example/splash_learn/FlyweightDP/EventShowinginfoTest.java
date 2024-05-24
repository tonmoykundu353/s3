package com.example.splash_learn.FlyweightDP;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EventShowinginfoTest {

    private EventShowinginfo eventShowinginfo;
    private EventSharedProperties eventSharedProperties;

    @Before
    public void setUp() {
        eventSharedProperties = new EventSharedProperties("kuet","bayzed"); // Assuming default constructor exists
        eventShowinginfo = new EventShowinginfo("Chess Club", "2024-06-15", "Annual Chess Tournament", "20", eventSharedProperties);
    }

    @Test
    public void testGetClubname() {
        assertEquals("Chess Club", eventShowinginfo.getClubname());
    }

    @Test
    public void testSetClubname() {
        eventShowinginfo.setClubname("Science Club");
        assertEquals("Science Club", eventShowinginfo.getClubname());
    }

    @Test
    public void testGetEventdate() {
        assertEquals("2024-06-15", eventShowinginfo.getEventdate());
    }

}



