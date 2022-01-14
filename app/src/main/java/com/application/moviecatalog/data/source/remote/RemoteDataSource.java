package com.application.moviecatalog.data.source.remote;

import com.application.moviecatalog.data.source.remote.response.movie.detail.DetailMovieResponse;
import com.application.moviecatalog.data.source.remote.response.movie.list.MovieResponse;
import com.application.moviecatalog.data.source.remote.response.tvShow.detail.DetailTvShowResponse;
import com.application.moviecatalog.data.source.remote.response.tvShow.list.TvShowResponse;
import com.application.moviecatalog.data.source.remote.retrofit.ApiConfig;

import retrofit2.Call;

public class RemoteDataSource {
    private static RemoteDataSource INSTANCE;

    private RemoteDataSource () {
    }

    public static RemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSource();
        }
        return INSTANCE;
    }

    public void callListMovie(LoadListMovieCallback callback) {
        callback.onAllListMovie(ApiConfig.getApiService().movieListResponseCall());
    }

    public void callDetailListMovie(int movieId, LoadDetailMovieCallback callback) {
        callback.onAllDetailMovie(ApiConfig.getApiService().movieDetailResponseCall(movieId));
    }

    public void callListTvShow(LoadListTvShowCallback callback) {
        callback.onAllListTvShow(ApiConfig.getApiService().tvShowListResponseCall());
    }

    public void callDetailListTvShow(int tvShowId, LoadDetailTvShowCallback callback) {
        callback.onAllDetailTvShow(ApiConfig.getApiService().tvShowDetailResponseCall(tvShowId));
    }

    public interface LoadListMovieCallback {
        void onAllListMovie(Call<MovieResponse> movieResultsItem);
    }

    public interface LoadDetailMovieCallback {
        void onAllDetailMovie(Call<DetailMovieResponse> movieDetailResponseCall);
    }


    public interface LoadListTvShowCallback {
        void onAllListTvShow(Call<TvShowResponse> tvShowResponseCall);
    }

    public interface LoadDetailTvShowCallback {
        void onAllDetailTvShow(Call<DetailTvShowResponse> tvShowDetailResponseCall);
    }
}
