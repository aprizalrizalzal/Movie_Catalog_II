package com.application.moviecatalog.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.application.moviecatalog.data.source.local.entity.GenresEntity;
import com.application.moviecatalog.data.source.local.entity.ProductionCompaniesEntity;
import com.application.moviecatalog.data.source.local.entity.ProductionCountriesEntity;
import com.application.moviecatalog.data.source.local.entity.SpokenLanguagesEntity;
import com.application.moviecatalog.data.source.local.entity.movie.detail.BelongsToCollectionEntity;
import com.application.moviecatalog.data.source.local.entity.movie.detail.DetailMovieEntity;
import com.application.moviecatalog.data.source.local.entity.tvShow.detail.CreatedByEntity;
import com.application.moviecatalog.data.source.local.entity.tvShow.detail.DetailTvShowEntity;
import com.application.moviecatalog.data.source.MovieCatalogRepository;
import com.application.moviecatalog.data.source.local.entity.tvShow.detail.LastEpisodeToAirEntity;
import com.application.moviecatalog.data.source.local.entity.tvShow.detail.NetworksEntity;
import com.application.moviecatalog.data.source.local.entity.tvShow.detail.SeasonsEntity;
import com.application.moviecatalog.data.source.remote.response.ProductionCompaniesItem;

import java.util.List;

public class DetailListViewModel extends ViewModel {
    private int moveId;
    private int tvId;
    private final MovieCatalogRepository catalogRepository;

    public void setMoveId(int moveId) {
        this.moveId = moveId;
    }

    public void setTvId(int tvId) {
        this.tvId = tvId;
    }

    public DetailListViewModel(MovieCatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public LiveData<DetailMovieEntity> getDetailMovie() {
        return catalogRepository.detailMovieEntity(moveId);
    }

    public LiveData<BelongsToCollectionEntity> getBelongsToCollectionMovie() {
        return catalogRepository.belongsToCollectionEntity(moveId);
    }

    public LiveData<List<GenresEntity>> getGenreMovie() {
        return catalogRepository.genresEntityMovie(moveId);
    }

    public LiveData<List<ProductionCompaniesEntity>> getProductionCompaniesMovie() {
        return catalogRepository.productionCompaniesEntityMovie(moveId);
    }

    public LiveData<List<ProductionCountriesEntity>> getProductionCountriesMovie() {
        return catalogRepository.productionCountriesEntityMovie(moveId);
    }

    public LiveData<List<SpokenLanguagesEntity>> getSpokenLanguagesMovie() {
        return catalogRepository.spokenLanguagesEntityMovie(moveId);
    }

    public LiveData<DetailTvShowEntity> getDetailTvShow() {
        return catalogRepository.detailTvShowEntity(tvId);
    }

    public LiveData<LastEpisodeToAirEntity> getLastEpisodeToAirEntity() {
        return catalogRepository.lastEpisodeToAirEntity(tvId);
    }

    public LiveData<List<GenresEntity>> getGenreTvSow() {
        return catalogRepository.genresEntityTvShow(tvId);
    }

    public LiveData<List<CreatedByEntity>> getCreatedByTvShow() {
        return catalogRepository.createdByEntityTvShow(tvId);
    }

    public LiveData<List<SeasonsEntity>> getSeasonsTvShow() {
        return catalogRepository.seasonsEntityTvShow(tvId);
    }

    public LiveData<List<NetworksEntity>> getNetworksTvShow() {
        return catalogRepository.networksEntityTvShow(tvId);
    }

    public LiveData<List<ProductionCompaniesEntity>> getProductionCompaniesTvShow() {
        return catalogRepository.productionCompaniesEntityTvShow(tvId);
    }

    public LiveData<List<ProductionCountriesEntity>> getProductionCountriesTvShow() {
        return catalogRepository.productionCountriesEntityTvShow(tvId);
    }

    public LiveData<List<SpokenLanguagesEntity>> getSpokenLanguagesTvShow() {
        return catalogRepository.spokenLanguagesEntityTvShow(tvId);
    }
}
