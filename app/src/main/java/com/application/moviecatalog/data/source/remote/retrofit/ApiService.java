package com.application.moviecatalog.data.source.remote.retrofit;

import com.application.moviecatalog.data.source.remote.response.GenresItem;
import com.application.moviecatalog.data.source.remote.response.movie.detail.BelongsToCollection;
import com.application.moviecatalog.data.source.remote.response.movie.detail.DetailMovieResponse;
import com.application.moviecatalog.data.source.remote.response.movie.list.MovieResponse;
import com.application.moviecatalog.data.source.remote.response.tvShow.detail.DetailTvShowResponse;
import com.application.moviecatalog.data.source.remote.response.tvShow.list.TvShowResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("movie/popular?api_key=46edd84156733bd5934e1cacc63b9e17&language=en-US&page=1")
    Call<MovieResponse> movieListResponseCall();

    @GET("movie/{movie_id}?api_key=46edd84156733bd5934e1cacc63b9e17&language=en-US")
    Call<DetailMovieResponse> movieDetailResponseCall(@Path("movie_id") int movieId);

    @GET("tv/popular?api_key=46edd84156733bd5934e1cacc63b9e17&language=en-US&page=1")
    Call<TvShowResponse> tvShowListResponseCall();

    @GET("tv/{tv_id}?api_key=46edd84156733bd5934e1cacc63b9e17&language=en-US")
    Call<DetailTvShowResponse> tvShowDetailResponseCall(@Path("tv_id") int tvId);
}
