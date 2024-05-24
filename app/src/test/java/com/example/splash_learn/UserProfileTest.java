package com.example.splash_learn;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import java.util.Map;

public class UserProfileTest {

    @Test
    public void testUserProfileBuilder() {
        UserProfile userProfile = new UserProfile.Builder()
                .setName("John Doe")
                .setEmail("john.doe@example.com")
                .setPassword("securepassword")
                .setCollegeName("Example University")
                .build();

        assertNotNull(userProfile);
        assertEquals("John Doe", userProfile.toMap().get("name"));
        assertEquals("john.doe@example.com", userProfile.toMap().get("email"));
        assertEquals("securepassword", userProfile.toMap().get("password"));
        assertEquals("Example University", userProfile.toMap().get("college_name"));
    }

    @Test
    public void testToMap() {
        UserProfile userProfile = new UserProfile.Builder()
                .setName("Jane Smith")
                .setEmail("jane.smith@example.com")
                .setPassword("anothersecurepassword")
                .setCollegeName("Sample College")
                .build();

        Map<String, Object> expectedMap = Map.of(
                "name", "Jane Smith",
                "email", "jane.smith@example.com",
                "password", "anothersecurepassword",
                "college_name", "Sample College"
        );

        Map<String, Object> actualMap = userProfile.toMap();
        assertEquals(expectedMap, actualMap);
    }
}
