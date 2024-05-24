package com.example.splash_learn;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

public class ChoiceBoxOrganizerActivityTest {

    @Rule
    public ActivityScenarioRule<ChoiceBoxOrganizerActivity> activityScenarioRule =
            new ActivityScenarioRule<>(ChoiceBoxOrganizerActivity.class);

    @Before
    public void setUp() {
        ActivityScenario.launch(ChoiceBoxOrganizerActivity.class);
    }

    @Test
    public void testGotoOrganizeEventButton() {
        // Check if the button is displayed
        Espresso.onView(withId(R.id.goto_organize_event_btn))
                .check(matches(isDisplayed()));

        // Perform click action
        Espresso.onView(withId(R.id.goto_organize_event_btn)).perform(ViewActions.click());

        // Check if the OrganizerActivity is launched
        Espresso.onView(withId(R.id.organizer_login_layout))
                .check(matches(isDisplayed()));
    }





    @Test
    public void testGotoShowStudentButton() {
        // Check if the button is displayed
        Espresso.onView(ViewMatchers.withId(R.id.goto_show_student_list))
                .check(matches(isDisplayed()));

        // Perform click action
        Espresso.onView(ViewMatchers.withId(R.id.goto_show_student_list)).perform(ViewActions.click());

        // Check if the ListView in RegisteredStudentEtEventActivity is displayed
        Espresso.onView(ViewMatchers.withId(R.id.Reg_stud_at_event_listview_id))
                .check(matches(isDisplayed()));

    }
}
