package com.application.moviecatalog.ui.tvShow;

import androidx.lifecycle.ViewModel;

import com.application.moviecatalog.data.TvShowEntity;
import com.application.moviecatalog.utils.TvShowItems;

import java.util.List;

public class TvShowViewModel extends ViewModel {

    public List<TvShowEntity> getTvShows() {
        return TvShowItems.tvShowEntities();
    }
}