package com.example.splash_learn;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class EventinfoTest {

    private Eventinfo eventinfo;

    @Before
    public void setUp() {
        eventinfo = new Eventinfo();
    }

    @Test
    public void testConstructorWithParameters() {
        Eventinfo ei = new Eventinfo("Tech Club", "Hackathon", "Auditorium", "50", "2024-06-01", "Alice");
        assertEquals("Tech Club", ei.getClubname());
        assertEquals("Hackathon", ei.getEventName());
        assertEquals("Auditorium", ei.getEventPlace());
        assertEquals("50", ei.getEventRegFees());
        assertEquals("2024-06-01", ei.getEventDate());
        assertEquals("Alice", ei.getOrganizedBy());
    }

    @Test
    public void testDefaultConstructor() {
        assertNotNull(eventinfo);
    }

    @Test
    public void testSetClubname() {
        eventinfo.setClubname("Art Club");
        assertEquals("Art Club", eventinfo.getClubname());
    }

    @Test
    public void testSetEventName() {
        eventinfo.setEventName("Painting Competition");
        assertEquals("Painting Competition", eventinfo.getEventName());
    }

    @Test
    public void testSetEventPlace() {
        eventinfo.setEventPlace("Hall A");
        assertEquals("Hall A", eventinfo.getEventPlace());
    }

    @Test
    public void testSetEventRegFees() {
        eventinfo.setEventRegFees("30");
        assertEquals("30", eventinfo.getEventRegFees());
    }

    @Test
    public void testSetEventDate() {
        eventinfo.setEventDate("2024-07-15");
        assertEquals("2024-07-15", eventinfo.getEventDate());
    }

    @Test
    public void testSetOrganizedBy() {
        eventinfo.setOrganizedBy("Bob");
        assertEquals("Bob", eventinfo.getOrganizedBy());
    }

    @Test
    public void testSetClubnameEmpty() {
        eventinfo.setClubname("");
        assertEquals("", eventinfo.getClubname());
    }

    @Test
    public void testSetEventNameEmpty() {
        eventinfo.setEventName("");
        assertEquals("", eventinfo.getEventName());
    }

    @Test
    public void testSetEventPlaceEmpty() {
        eventinfo.setEventPlace("");
        assertEquals("", eventinfo.getEventPlace());
    }

    @Test
    public void testSetEventRegFeesEmpty() {
        eventinfo.setEventRegFees("");
        assertEquals("", eventinfo.getEventRegFees());
    }

    @Test
    public void testSetEventDateEmpty() {
        eventinfo.setEventDate("");
        assertEquals("", eventinfo.getEventDate());
    }

    @Test
    public void testSetOrganizedByEmpty() {
        eventinfo.setOrganizedBy("");
        assertEquals("", eventinfo.getOrganizedBy());
    }

    @Test
    public void testConstructorWithEmptyParameters() {
        Eventinfo ei = new Eventinfo("", "", "", "", "", "");
        assertEquals("", ei.getClubname());
        assertEquals("", ei.getEventName());
        assertEquals("", ei.getEventPlace());
        assertEquals("", ei.getEventRegFees());
        assertEquals("", ei.getEventDate());
        assertEquals("", ei.getOrganizedBy());
    }
}
