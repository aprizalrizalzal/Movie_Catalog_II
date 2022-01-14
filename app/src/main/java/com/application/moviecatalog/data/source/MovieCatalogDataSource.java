package com.application.moviecatalog.data.source;

import androidx.lifecycle.LiveData;

import com.application.moviecatalog.data.source.local.entity.GenresEntity;
import com.application.moviecatalog.data.source.local.entity.ProductionCompaniesEntity;
import com.application.moviecatalog.data.source.local.entity.ProductionCountriesEntity;
import com.application.moviecatalog.data.source.local.entity.SpokenLanguagesEntity;
import com.application.moviecatalog.data.source.local.entity.movie.detail.BelongsToCollectionEntity;
import com.application.moviecatalog.data.source.local.entity.movie.detail.DetailMovieEntity;
import com.application.moviecatalog.data.source.local.entity.movie.list.MovieEntity;
import com.application.moviecatalog.data.source.local.entity.tvShow.detail.CreatedByEntity;
import com.application.moviecatalog.data.source.local.entity.tvShow.detail.DetailTvShowEntity;
import com.application.moviecatalog.data.source.local.entity.tvShow.detail.LastEpisodeToAirEntity;
import com.application.moviecatalog.data.source.local.entity.tvShow.detail.NetworksEntity;
import com.application.moviecatalog.data.source.local.entity.tvShow.detail.SeasonsEntity;
import com.application.moviecatalog.data.source.local.entity.tvShow.list.TvShowEntity;

import java.util.List;

public interface MovieCatalogDataSource {

    LiveData<List<MovieEntity>> movieEntities();

    LiveData<DetailMovieEntity> detailMovieEntity(int movieId);

    LiveData<BelongsToCollectionEntity> belongsToCollectionEntity(int movieId);

    LiveData<List<GenresEntity>> genresEntityMovie(int movieId);

    LiveData<List<ProductionCompaniesEntity>> productionCompaniesEntityMovie(int movieId);

    LiveData<List<ProductionCountriesEntity>> productionCountriesEntityMovie(int movieId);

    LiveData<List<SpokenLanguagesEntity>> spokenLanguagesEntityMovie(int movieId);

    LiveData<List<TvShowEntity>> tvShowEntities();

    LiveData<DetailTvShowEntity> detailTvShowEntity(int tvId);

    LiveData<LastEpisodeToAirEntity> lastEpisodeToAirEntity(int tvId);

    LiveData<List<GenresEntity>> genresEntityTvShow(int tvId);

    LiveData<List<CreatedByEntity>> createdByEntityTvShow(int tvId);

    LiveData<List<ProductionCompaniesEntity>> productionCompaniesEntityTvShow(int tvId);

    LiveData<List<NetworksEntity>> networksEntityTvShow(int tvId);

    LiveData<List<SeasonsEntity>> seasonsEntityTvShow(int tvId);

    LiveData<List<ProductionCountriesEntity>> productionCountriesEntityTvShow(int tvId);

    LiveData<List<SpokenLanguagesEntity>> spokenLanguagesEntityTvShow(int tvId);
}
