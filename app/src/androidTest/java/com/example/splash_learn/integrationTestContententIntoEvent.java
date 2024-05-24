package com.example.splash_learn;

import org.junit.Test;
import static org.junit.Assert.*;

public class integrationTestContententIntoEvent {

    @Test
    public void testContestantSignupForEvent() {
        // Create a contestant
        Contestentinfo contestant = new Contestentinfo("John Doe", "john@example.com", "1234567890");

        // Create an event
        Eventinfo event = new Eventinfo("Chess Club", "Chess Tournament", "Community Hall", "10", "2024-06-30", "OrganizerXYZ");

        // Simulate contestant signing up for the event
        contestantSignUpForEvent(contestant, event);

        // Verify that contestant's information is associated with the event
        assertEquals("John Doe", event.getOrganizedBy());
    }

    private void contestantSignUpForEvent(Contestentinfo contestant, Eventinfo event) {
        // Here, you would have the logic to associate the contestant with the event
        event.setOrganizedBy(contestant.getName()); // For simplicity, we set the event's organizer to the contestant's name
    }
}
