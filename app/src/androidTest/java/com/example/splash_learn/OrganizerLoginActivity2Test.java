package com.example.splash_learn;

import android.content.Intent;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class OrganizerLoginActivity2Test {

    @Rule
    public IntentsTestRule<OrganizerLoginActivity2> intentsTestRule =
            new IntentsTestRule<>(OrganizerLoginActivity2.class, true, false);

    @Before
    public void setup() {
        // Initialize Firebase
        FirebaseApp.initializeApp(InstrumentationRegistry.getInstrumentation().getTargetContext());

        // Set up the Firebase database with the correct credentials
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("OrganizerRegistrationSection").child("2207063");
        ref.child("uni_name").setValue("KUET");
        ref.child("uni_password").setValue("2207063");
        ref.child("uni_roll").setValue("2207063");

        // Launch the activity
        intentsTestRule.launchActivity(new Intent());
    }//ai info gulu kintu firebase e store hobe na..........................+ joto gulu test case likbo sob kintu ai setup funcrion ta kei ref hissabe dhorbe
//---------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //**************************************************************************************



    @Test
    public void testLoginWithCorrectCredentials() throws InterruptedException {
        // Type the correct university name, roll number, and password
        onView(withId(R.id.id_enter_organizer_university_spinner2)).perform(click());
        onView(withText("KUET")).perform(click());

        onView(withId(R.id.id_enter_organizer_roll2)).perform(typeText("2207063"), closeSoftKeyboard());
        onView(withId(R.id.id_enter_organizer_password2)).perform(typeText("2207063"), closeSoftKeyboard());

        // Click the login button
        onView(withId(R.id.id_organizer_login_btn2)).perform(click());

        // Add a sleep to ensure the intent is triggered
        Thread.sleep(2000); // Sleep for 2 seconds

        // Check if the intent changes to ChoiceBoxOrganizerActivity
        intended(hasComponent(ChoiceBoxOrganizerActivity.class.getName()));
    }




    @Test
    public void testLoginWithCorrectCredentials2() throws InterruptedException {
        // Type the correct university name, roll number, and password
        onView(withId(R.id.id_enter_organizer_university_spinner2)).perform(click());
        onView(withText("KUET")).perform(click());

        onView(withId(R.id.id_enter_organizer_roll2)).perform(typeText("2207065"), closeSoftKeyboard());
        onView(withId(R.id.id_enter_organizer_password2)).perform(typeText("2207063"), closeSoftKeyboard());

        // Click the login button
        onView(withId(R.id.id_organizer_login_btn2)).perform(click());

        // Add a sleep to ensure the intent is triggered
        Thread.sleep(2000); // Sleep for 2 seconds

        // Check if the intent changes to ChoiceBoxOrganizerActivity
        intended(hasComponent(ChoiceBoxOrganizerActivity.class.getName()));
    }
}
////*******************************Perfect Testing******************************************
//
//
//
//
//
//
//
//






