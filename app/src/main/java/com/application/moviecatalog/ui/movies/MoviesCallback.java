package com.application.moviecatalog.ui.movies;

import com.application.moviecatalog.data.MovieEntity;

public interface MoviesCallback {
    void onItemClick(MovieEntity movieEntity);
    void onShareClick(MovieEntity movieEntity);
}
