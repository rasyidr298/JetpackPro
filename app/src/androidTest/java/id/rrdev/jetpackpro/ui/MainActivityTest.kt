package id.rrdev.jetpackpro.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import id.rrdev.jetpackpro.R
import id.rrdev.jetpackpro.utils.MovieDummy
import org.junit.Before
import org.junit.Test

class MainActivityTest {

    private val dummyMovies = MovieDummy.getMovies()
    private val dummyTvShows = MovieDummy.getTvShow()

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun loadMovies() {
        Espresso.onView(withId(R.id.rvMovie))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rvMovie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovies.size
            )
        )
    }

    @Test
    fun loadDetailMovie() {
        Espresso.onView(withId(R.id.rvMovie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        Espresso.onView(withId(R.id.imgDetailMovie))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.nestedScroll)).perform(
            ViewActions.swipeUp()
        )
        Espresso.onView(withId(R.id.txtOverview))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.txtOverview))
            .check(ViewAssertions.matches(withText(dummyMovies[0].overview)))

        Espresso.onView(withId(R.id.txtTitleMovie))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.txtTitleMovie))
            .check(ViewAssertions.matches(withText(dummyMovies[0].title)))

        Espresso.onView(withId(R.id.txtGenre))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.txtGenre))
            .check(ViewAssertions.matches(withText(dummyMovies[0].genre)))

        Espresso.onView(withId(R.id.txtDateOfRelease))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.txtDateOfRelease))
            .check(ViewAssertions.matches(withText(dummyMovies[0].dateOfRelease)))

        Espresso.onView(withId(R.id.txtDuration))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.txtDuration))
            .check(ViewAssertions.matches(withText(dummyMovies[0].duration)))
    }

    @Test
    fun loadTvShows() {
        Espresso.onView(ViewMatchers.withText("TvShow")).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rvTvShow))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rvTvShow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTvShows.size
            )
        )
    }

    @Test
    fun loadDetailTvShow() {
        Espresso.onView(ViewMatchers.withText("TvShow")).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rvTvShow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        Espresso.onView(withId(R.id.imgDetailMovie))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.nestedScroll)).perform(
            ViewActions.swipeUp()
        )
        Espresso.onView(withId(R.id.txtOverview))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.txtOverview))
            .check(ViewAssertions.matches(withText(dummyTvShows[0].overview)))

        Espresso.onView(withId(R.id.txtTitleMovie))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.txtTitleMovie))
            .check(ViewAssertions.matches(withText(dummyTvShows[0].title)))

        Espresso.onView(withId(R.id.txtGenre))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.txtGenre))
            .check(ViewAssertions.matches(withText(dummyTvShows[0].genre)))

        Espresso.onView(withId(R.id.txtDateOfRelease))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.txtDateOfRelease))
            .check(ViewAssertions.matches(withText(dummyTvShows[0].dateOfRelease)))

        Espresso.onView(withId(R.id.txtDuration))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.txtDuration))
            .check(ViewAssertions.matches(withText(dummyTvShows[0].duration)))
    }

}