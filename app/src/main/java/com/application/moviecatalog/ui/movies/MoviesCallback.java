package com.application.moviecatalog.ui.movies;

import com.application.moviecatalog.data.source.local.entity.movie.list.MovieEntity;

public interface MoviesCallback {
    void onItemClick(MovieEntity movieEntity);
    void onShareClick(MovieEntity movieEntity);
}
