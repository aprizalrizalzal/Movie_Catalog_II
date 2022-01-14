package com.application.moviecatalog.ui.tvShow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.application.moviecatalog.data.source.local.entity.tvShow.list.TvShowEntity;
import com.application.moviecatalog.data.source.MovieCatalogRepository;

import java.util.List;

public class TvShowViewModel extends ViewModel {
    private final MovieCatalogRepository catalogRepository;
    public TvShowViewModel(MovieCatalogRepository catalogRepository){
        this.catalogRepository = catalogRepository;
    }
    public LiveData<List<TvShowEntity>> getTvShows() {
        return catalogRepository.tvShowEntities();
    }
}