package com.application.moviecatalog.utils;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.application.moviecatalog.data.source.MovieCatalogRepository;
import com.application.moviecatalog.ui.detail.DetailListViewModel;
import com.application.moviecatalog.ui.movies.MoviesViewModel;
import com.application.moviecatalog.ui.tvShow.TvShowViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;

    private final MovieCatalogRepository catalogRepository;
    private Context context;

    public ViewModelFactory(MovieCatalogRepository catalogRepository, Context context) {
        this.catalogRepository = catalogRepository;
        this.context = context;
    }

    public static ViewModelFactory getInstance(MovieCatalogRepository catalogRepository, Context context){
        if (INSTANCE == null){
            synchronized (ViewModelFactory.class) {
                INSTANCE = new ViewModelFactory(catalogRepository, context);
            }
        }
        return INSTANCE;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(MoviesViewModel.class)) {
            return (T) new MoviesViewModel(catalogRepository);
        } else if (modelClass.isAssignableFrom(TvShowViewModel.class)) {
            return (T) new TvShowViewModel(catalogRepository);
        } else if (modelClass.isAssignableFrom(DetailListViewModel.class)) {
            return (T) new DetailListViewModel(catalogRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
