package com.application.moviecatalog.ui.movies;

import static org.junit.Assert.*;

import com.application.moviecatalog.data.MovieEntity;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MoviesViewModelTest {
    private MoviesViewModel viewModel;

    @Before
    public void setUp(){
        viewModel = new MoviesViewModel();
    }

    @Test
    public void getMovies() {
        List<MovieEntity> movieEntities = viewModel.getMovies();
        assertNotNull(movieEntities);
        assertEquals(20, movieEntities.size());
    }
}