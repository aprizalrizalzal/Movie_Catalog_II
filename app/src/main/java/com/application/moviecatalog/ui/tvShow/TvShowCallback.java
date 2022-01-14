package com.application.moviecatalog.ui.tvShow;

import com.application.moviecatalog.data.source.local.entity.tvShow.list.TvShowEntity;

public interface TvShowCallback {
    void onItemClick(TvShowEntity tvShowEntity);
    void onShareClick(TvShowEntity tvShowEntity);
}
