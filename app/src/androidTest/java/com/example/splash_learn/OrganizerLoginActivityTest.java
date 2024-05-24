package com.example.splash_learn;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class OrganizerLoginActivityTest {
    @Rule
    public ActivityScenarioRule<OrganizerLoginActivity> activityScenarioRule =
            new ActivityScenarioRule<>(OrganizerLoginActivity.class);

    @Test
    public void showbtn_check(){
        String validRollNumber = "1234567";
        // Enter long comment
        Espresso.onView(ViewMatchers.withId(R.id.id_enter_organizer_roll))
                .perform(ViewActions.replaceText(validRollNumber));

        Espresso.onView(ViewMatchers.withId(R.id.id_enter_organizer_password)).perform(ViewActions.replaceText("12345"));
        Espresso.onView(ViewMatchers.withId(R.id.id_organizer_login_btn)).perform(ViewActions.click());
        // Check if the error message is displayed correctly
        Espresso.onView(ViewMatchers.withId(R.id.Organizert_login_toastshowing_textview))
                .check(ViewAssertions.matches(ViewMatchers.withText("Password must be graeter  than 6 charecters")));


    }







    @Test
    public void showbtn_check3() {
        // Enter a valid university roll number and password to meet the conditions
        String invalidRollNumber = "123456";
        String validPassword = "123456";

        // Enter the valid password
        Espresso.onView(ViewMatchers.withId(R.id.id_enter_organizer_password))
                .perform(ViewActions.replaceText(validPassword));
        // Enter the valid roll number
        Espresso.onView(ViewMatchers.withId(R.id.id_enter_organizer_roll))
                .perform(ViewActions.replaceText(invalidRollNumber));
        // Click the login button
        Espresso.onView(ViewMatchers.withId(R.id.id_organizer_login_btn)).perform(ViewActions.click());

        // Check if the error message is displayed correctly
        Espresso.onView(ViewMatchers.withId(R.id.Organizert_login_toastshowing_textview))
                .check(ViewAssertions.matches(ViewMatchers.withText("Invalid roll number")));
    }




    @Test
    public void showbtn_check4() {
        // Enter a valid university roll number and password to meet the conditions
        String validRollNumber = "12345678";
        String validPassword = "1234567";

        // Enter the valid password
        Espresso.onView(ViewMatchers.withId(R.id.id_enter_organizer_password))
                .perform(ViewActions.replaceText(validPassword));
        // Enter the valid roll number
        Espresso.onView(ViewMatchers.withId(R.id.id_enter_organizer_roll))
                .perform(ViewActions.replaceText(validRollNumber));
        // Click the login button
        Espresso.onView(ViewMatchers.withId(R.id.id_organizer_login_btn)).perform(ViewActions.click());

        // Verifies that the second activity is displayed
//        Espresso.onView(ViewMatchers.withId(R.id.organizer_login_layout))
//                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        // Check if the error message is displayed correctly
        Espresso.onView(ViewMatchers.withId(R.id.Organizert_login_toastshowing_textview))
                .check(ViewAssertions.matches(ViewMatchers.withText("Invalid roll number")));


    }






    @Test
    public void showbtn_check5() {
        // Enter a valid university roll number and password to meet the conditions
        String validRollNumber = "12345678";
        String validPassword = "1234567";

        // Enter the valid password
        Espresso.onView(ViewMatchers.withId(R.id.id_enter_organizer_password))
                .perform(ViewActions.replaceText(validPassword));
        // Enter the valid roll number
        Espresso.onView(ViewMatchers.withId(R.id.id_enter_organizer_roll))
                .perform(ViewActions.replaceText(validRollNumber));
        // Click the login button
        Espresso.onView(ViewMatchers.withId(R.id.id_organizer_login_btn)).perform(ViewActions.click());

        // Verifies that the second activity is displayed
       Espresso.onView(ViewMatchers.withId(R.id.organizer_login_layout))
               .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));


    }





}
