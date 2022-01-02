package com.application.moviecatalog.ui.tvShow;

import com.application.moviecatalog.data.TvShowEntity;

public interface TvShowCallback {
    void onItemClick(TvShowEntity tvShowEntity);
    void onShareClick(TvShowEntity tvShowEntity);
}
