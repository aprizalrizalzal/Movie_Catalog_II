package com.application.moviecatalog.ui.detail;

import static org.junit.Assert.*;

import com.application.moviecatalog.data.MovieEntity;
import com.application.moviecatalog.data.TvShowEntity;
import com.application.moviecatalog.utils.MovieItems;
import com.application.moviecatalog.utils.TvShowItems;

import org.junit.Before;
import org.junit.Test;

public class DetailListViewModelTest {
    private DetailListViewModel viewModel;

    private final MovieEntity detailMovies = MovieItems.movieEntities().get(0);
    private final int moviesId = detailMovies.getId();

    private final TvShowEntity detailTvShow = TvShowItems.tvShowEntities().get(0);
    private final int tvShowId = detailTvShow.getId();

    @Before
    public void setUp(){
        viewModel = new DetailListViewModel();
        viewModel.getMovie(moviesId);
        viewModel.getTvShow(tvShowId);
    }

    @Test
    public void getMoviesCatalog() {
        viewModel.getMovie(detailMovies.getId());
        MovieEntity movieEntity = viewModel.getMovie(moviesId);
        assertNotNull(movieEntity);
        assertEquals(detailMovies.getId(), movieEntity.getId());
        assertEquals(detailMovies.getPosterPath(), movieEntity.getPosterPath());
        assertEquals(detailMovies.getTitle(), movieEntity.getTitle());
        assertEquals(detailMovies.getReleaseDate(), movieEntity.getReleaseDate());
        assertEquals(detailMovies.getVoteAverage(), movieEntity.getVoteAverage());
        assertEquals(detailMovies.getOriginalLanguage(), movieEntity.getOriginalLanguage());
        assertEquals(detailMovies.getOverview(), movieEntity.getOverview());
    }

    @Test
    public void getTvShowCatalog() {
        viewModel.getTvShow(detailTvShow.getId());
        TvShowEntity tvShowEntity = viewModel.getTvShow(tvShowId);
        assertNotNull(tvShowEntity);
        assertEquals(detailTvShow.getId(), tvShowEntity.getId());
        assertEquals(detailTvShow.getPosterPath(), tvShowEntity.getPosterPath());
        assertEquals(detailTvShow.getName(), tvShowEntity.getName());
        assertEquals(detailTvShow.getFirstAirDate(), tvShowEntity.getFirstAirDate());
        assertEquals(detailTvShow.getVoteAverage(), tvShowEntity.getVoteAverage());
        assertEquals(detailTvShow.getOriginalLanguage(), tvShowEntity.getOriginalLanguage());
        assertEquals(detailTvShow.getOverview(), tvShowEntity.getOverview());
    }

}