//package com.example.splash_learn;
//
//import static androidx.test.espresso.assertion.ViewAssertions.matches;
//import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
//import static org.awaitility.Awaitility.await;
//
//import androidx.test.espresso.Espresso;
//import androidx.test.espresso.action.ViewActions;
//import androidx.test.espresso.matcher.ViewMatchers;
//import androidx.test.ext.junit.rules.ActivityScenarioRule;
//
//import com.example.splash_learn.matchers.ToastMatcher;
//import com.google.firebase.database.FirebaseDatabase;
//
//import org.junit.After;
//import org.junit.Rule;
//import org.junit.Test;
//
//public class DetailofEventShowingActivityTest {
//
//    @Rule
//    public ActivityScenarioRule<DetailofEventShowingActivity> activityScenarioRule =
//            new ActivityScenarioRule<>(DetailofEventShowingActivity.class);
//
//    @After
//    public void cleanup() {
//        // Clear database after each test to ensure consistency
//        FirebaseDatabase.getInstance().purgeOutstandingWrites();
//    }
//
//    @Test
//    public void testRegisterButton() {
//        // Check if the EditText fields and the register button are displayed
//        Espresso.onView(ViewMatchers.withId(R.id.contestent_name))
//                .check(matches(isDisplayed()));
//        Espresso.onView(ViewMatchers.withId(R.id.contestent_email))
//                .check(matches(isDisplayed()));
//        Espresso.onView(ViewMatchers.withId(R.id.contestent_college))
//                .check(matches(isDisplayed()));
//        Espresso.onView(ViewMatchers.withId(R.id.regbtn_for_contest))
//                .check(matches(isDisplayed()));
//
//        // Perform input actions
//        Espresso.onView(ViewMatchers.withId(R.id.contestent_name))
//                .perform(ViewActions.typeText("John Doe"));
//        Espresso.onView(ViewMatchers.withId(R.id.contestent_email))
//                .perform(ViewActions.typeText("john@example.com"));
//        Espresso.onView(ViewMatchers.withId(R.id.contestent_college))
//                .perform(ViewActions.typeText("College XYZ"));
//
//        // Close soft keyboard
//        Espresso.closeSoftKeyboard();
//
//        // Perform click action on the register button
//        Espresso.onView(ViewMatchers.withId(R.id.regbtn_for_contest))
//                .perform(ViewActions.click());
//
//
//
//        // Wait for the database operation to complete
//        await().untilAsserted(() -> {
//            FirebaseDatabase.getInstance().getReference().child("Contestentinfo").child("User").child("John Doe")
//                    .addListenerForSingleValueEvent(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                            assertThat(dataSnapshot.exists()).isTrue();
//                        }
//
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError databaseError) {
//                            // Handle onCancelled event
//                        }
//                    });
//        });
//
//        // Check if the "User information is successfully added" toast message is displayed
//        Espresso.onView(ViewMatchers.withText("User information is successfully added"))
//                .inRoot(new ToastMatcher())
//                .check(matches(isDisplayed()));
//    }
//}
//
