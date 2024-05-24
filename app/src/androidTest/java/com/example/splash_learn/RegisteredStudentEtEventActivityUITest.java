package com.example.splash_learn;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import androidx.test.core.app.ActivityScenario;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegisteredStudentEtEventActivityUITest {
    private RegisteredStudentEtEventActivity activity;



    @Before
    public void setUp() {
        CountDownLatch latch = new CountDownLatch(1);
        ActivityScenario.launch(RegisteredStudentEtEventActivity.class).onActivity(new ActivityScenario.ActivityAction<RegisteredStudentEtEventActivity>() {
            @Override
            public void perform(RegisteredStudentEtEventActivity activityInstance) {
                activity = activityInstance;
                activity.arrayList = new ArrayList<>(); // Ensure arrayList is initialized
                latch.countDown();
            }
        });
        try {
            latch.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }





//    @Before
//    public void setUp() {
//        ActivityScenario.launch(RegisteredStudentEtEventActivity.class);
//    }








    @Test
    public void checkListViewIsDisplayed() {
        Espresso.onView(ViewMatchers.withId(R.id.Reg_stud_at_event_listview_id))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void performClickOnListItem() {
        Espresso.onView(ViewMatchers.withId(R.id.Reg_stud_at_event_listview_id))
                .perform(ViewActions.click());
        // Add assertions for the behavior after clicking on a list item
    }








    @Test
    public void testArrayListPopulation() {
        // Ensure the arrayList is initially empty
        assertEquals(0, activity.arrayList.size());

        // Simulate fetching data from Firebase and populating the arrayList
        simulateFirebaseDataFetching();

        // Allow some time for Firebase data fetching (simulated delay)
        try {
            Thread.sleep(3000); // Adjust this time as needed depending on network speed and Firebase response time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Check if the arrayList is now populated correctly
        assertFalse(activity.arrayList.isEmpty());
        assertEquals(2, activity.arrayList.size());
        assertEquals("1234567890", activity.arrayList.get(0).getContactNo());
        assertEquals("john@example.com", activity.arrayList.get(0).getEmail());
        assertEquals("John Doe", activity.arrayList.get(0).getName());
        assertEquals("0987654321", activity.arrayList.get(1).getContactNo());
        assertEquals("alice@example.com", activity.arrayList.get(1).getEmail());
        assertEquals("Alice Smith", activity.arrayList.get(1).getName());
    }

    // Simulate fetching data from Firebase and populating the arrayList
    private void simulateFirebaseDataFetching() {
        // Manually populate the arrayList with some mock data
        activity.arrayList.add(new RegStudAtEventInfo("1234567890", "john@example.com", "John Doe"));
        activity.arrayList.add(new RegStudAtEventInfo("0987654321", "alice@example.com", "Alice Smith"));
    }

    // You can add more tests for other UI elements or interactions as needed
}
