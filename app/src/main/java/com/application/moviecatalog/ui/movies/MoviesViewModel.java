package com.application.moviecatalog.ui.movies;

import androidx.lifecycle.ViewModel;

import com.application.moviecatalog.data.MovieEntity;
import com.application.moviecatalog.utils.MovieItems;

import java.util.List;

public class MoviesViewModel extends ViewModel {

    public List<MovieEntity> getMovies() {
        return MovieItems.movieEntities();
    }
}