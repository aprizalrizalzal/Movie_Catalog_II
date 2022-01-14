package com.application.moviecatalog.ui.movies;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.application.moviecatalog.data.source.local.entity.movie.list.MovieEntity;
import com.application.moviecatalog.data.source.MovieCatalogRepository;

import java.util.List;

public class MoviesViewModel extends ViewModel {
    private final MovieCatalogRepository catalogRepository;
    public MoviesViewModel(MovieCatalogRepository catalogRepository){
        this.catalogRepository = catalogRepository;
    }

    public LiveData<List<MovieEntity>> getMovies() {
        return catalogRepository.movieEntities();
    }
}