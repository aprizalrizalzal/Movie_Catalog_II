package com.application.moviecatalog.ui.detail;

import androidx.lifecycle.ViewModel;

import com.application.moviecatalog.data.MovieEntity;
import com.application.moviecatalog.data.TvShowEntity;
import com.application.moviecatalog.utils.MovieItems;
import com.application.moviecatalog.utils.TvShowItems;

import java.util.List;

public class DetailListViewModel extends ViewModel {
    public MovieEntity getMovie(int movieId) {
        MovieEntity movieEntity = null;
        List<MovieEntity> movieEntities = MovieItems.movieEntities();
        for (MovieEntity listMovieEntity : movieEntities) {
            if (listMovieEntity.getId() == (movieId)) {
                movieEntity = listMovieEntity;
            }
        }
        return movieEntity;
    }

    public TvShowEntity getTvShow(int tvShowId) {
        TvShowEntity tvShowEntity = null;
        List<TvShowEntity> tvShowEntities = TvShowItems.tvShowEntities();
        for (TvShowEntity ListTvShowEntity : tvShowEntities) {
            if (ListTvShowEntity.getId() == (tvShowId)) {
                tvShowEntity = ListTvShowEntity;
            }
        }
        return tvShowEntity;
    }
}
