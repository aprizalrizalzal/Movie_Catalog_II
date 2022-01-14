//package com.application.moviecatalog.ui;
//
//import static androidx.test.espresso.Espresso.onView;
//import static androidx.test.espresso.action.ViewActions.click;
//import static androidx.test.espresso.assertion.ViewAssertions.matches;
//import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
//import static androidx.test.espresso.matcher.ViewMatchers.withId;
//import static androidx.test.espresso.matcher.ViewMatchers.withText;
//
//import androidx.test.espresso.contrib.RecyclerViewActions;
//import androidx.test.ext.junit.rules.ActivityScenarioRule;
//
//import com.application.moviecatalog.R;
//import com.application.moviecatalog.data.source.local.entity.movie.list.MovieEntity;
//import com.application.moviecatalog.data.source.local.entity.tvShow.list.TvShowEntity;
//import com.application.moviecatalog.utils.MovieItems;
//import com.application.moviecatalog.utils.TvShowItems;
//
//import org.junit.Rule;
//import org.junit.Test;
//
//import java.util.List;
//
//public class MainHomeActivityTest {
//
//    private final List<MovieEntity> detailMovies = MovieItems.movieEntities();
//    private final List<TvShowEntity> detailTvShow = TvShowItems.tvShowEntities();
//
//    @Rule
//    public ActivityScenarioRule rule = new ActivityScenarioRule<>(MainHomeActivity.class);
//
//    @Test
//    public void loadMovies() {
//        onView(withText("Movies")).perform(click());
//        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()));
//        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition(detailMovies.size()));
//    }
//
//    @Test
//    public void loadDetailMovies() {
//        onView(withText("Movies")).perform(click());
//        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
//        onView(withId(R.id.img_btn_detail_link)).perform(click());
//    }
//
//    @Test
//    public void loadTvShow() {
//        onView(withText("Tv show")).perform(click());
//        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()));
//        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.scrollToPosition(detailTvShow.size()));
//    }
//
//    @Test
//    public void loadDetailTvShow() {
//        onView(withText("Tv show")).perform(click());
//        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
//        onView(withId(R.id.img_btn_detail_link)).perform(click());
//    }
//}