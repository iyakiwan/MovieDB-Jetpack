package com.example.java.submission_jetpack.ui;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import com.example.java.submission_jetpack.R;
import com.example.java.submission_jetpack.ui.home.HomeActivity;
import com.example.java.submission_jetpack.utils.EspressoIdlingResource;
import com.example.java.submission_jetpack.utils.RecyclerViewItemCountAssertion;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.action.ViewActions.swipeRight;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;

public class SubmissionTest {

    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<>(HomeActivity.class);

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void toFragmentMovieTest() {
        onView(withId(R.id.view_pager)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_fragment_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_fragment_movie)).check(new RecyclerViewItemCountAssertion(20));
        onView(withId(R.id.rv_fragment_movie)).perform(RecyclerViewActions.scrollToPosition(20));
    }

    @Test
    public void toFragmentTvShowTest() {
        onView(withId(R.id.view_pager)).check(matches(isDisplayed()));
        onView(withId(R.id.view_pager)).perform(swipeLeft());
        onView(withId(R.id.rv_fragment_tv)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_fragment_tv)).check(new RecyclerViewItemCountAssertion(20));
        onView(withId(R.id.rv_fragment_tv)).perform(RecyclerViewActions.scrollToPosition(20));
    }

    @Test
    public void toDetailActivityMovieTest() {
        onView(withId(R.id.view_pager)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_fragment_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_fragment_movie)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()));
        onView(withId(R.id.img_detail_poster)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_detail_title)).check(matches(not("")));
    }

    @Test
    public void toDetailActivityTvTest() {
        onView(withId(R.id.view_pager)).check(matches(isDisplayed()));
        onView(withId(R.id.view_pager)).perform(swipeLeft());
        onView(withId(R.id.rv_fragment_tv)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_fragment_tv)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()));
        onView(withId(R.id.img_detail_poster)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_detail_title)).check(matches(not("")));
    }

    @Test
    public void toFavoriteMovie() {
        onView(withId(R.id.view_pager)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_fragment_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_fragment_movie)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()));
        onView(withId(R.id.img_detail_poster)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_detail_title)).check(matches(not("")));
        onView(withId(R.id.action_favorite)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(withId(R.id.fab_favorite)).perform(click());
        onView(withId(R.id.nav_fragment)).check(matches(isDisplayed()));
        onView(withId(R.id.navigation_fav_movie)).perform(click());
        onView(withId(R.id.rv_fragment_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_fragment_movie)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()));
        onView(withId(R.id.img_detail_poster)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_detail_title)).check(matches(not("")));
        onView(withId(R.id.action_favorite)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(isRoot()).perform(ViewActions.pressBack());
    }

    @Test
    public void toFavoriteTv() {
        onView(withId(R.id.view_pager)).check(matches(isDisplayed()));
        onView(withId(R.id.view_pager)).perform(swipeLeft());
        onView(withId(R.id.rv_fragment_tv)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_fragment_tv)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()));
        onView(withId(R.id.img_detail_poster)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_detail_title)).check(matches(not("")));
        onView(withId(R.id.action_favorite)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(withId(R.id.view_pager)).perform(swipeRight());
        onView(withId(R.id.fab_favorite)).perform(click());
        onView(withId(R.id.nav_fragment)).check(matches(isDisplayed()));
        onView(withId(R.id.navigation_fav_tv)).perform(click());
        onView(withId(R.id.rv_fragment_tv)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_fragment_tv)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()));
        onView(withId(R.id.img_detail_poster)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_detail_title)).check(matches(not("")));
        onView(withId(R.id.action_favorite)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(isRoot()).perform(ViewActions.pressBack());
    }

    @Test
    public void toAllTestActivity() {
        onView(withId(R.id.view_pager)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_fragment_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_fragment_movie)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_detail_title)).check(matches(not("")));
        onView(withId(R.id.action_favorite)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(withId(R.id.view_pager)).check(matches(isDisplayed()));
        onView(withId(R.id.view_pager)).perform(swipeLeft());
        onView(withId(R.id.rv_fragment_tv)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_fragment_tv)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_detail_title)).check(matches(not("")));
        onView(withId(R.id.action_favorite)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(withId(R.id.view_pager)).perform(swipeRight());
        onView(withId(R.id.fab_favorite)).perform(click());
        onView(withId(R.id.nav_fragment)).check(matches(isDisplayed()));
        onView(withId(R.id.navigation_fav_movie)).perform(click());
        onView(withId(R.id.rv_fragment_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_fragment_movie)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()));
        onView(withId(R.id.img_detail_poster)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_detail_title)).check(matches(not("")));
        onView(withId(R.id.action_favorite)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(withId(R.id.nav_fragment)).check(matches(isDisplayed()));
        onView(withId(R.id.navigation_fav_tv)).perform(click());
        onView(withId(R.id.rv_fragment_tv)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_fragment_tv)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()));
        onView(withId(R.id.img_detail_poster)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_detail_title)).check(matches(not("")));
        onView(withId(R.id.action_favorite)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(isRoot()).perform(ViewActions.pressBack());
    }

}
