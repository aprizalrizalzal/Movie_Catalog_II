package com.application.moviecatalog.data.source;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

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
import com.application.moviecatalog.data.source.remote.RemoteDataSource;
import com.application.moviecatalog.data.source.remote.response.GenresItem;
import com.application.moviecatalog.data.source.remote.response.ProductionCompaniesItem;
import com.application.moviecatalog.data.source.remote.response.ProductionCountriesItem;
import com.application.moviecatalog.data.source.remote.response.SpokenLanguagesItem;
import com.application.moviecatalog.data.source.remote.response.movie.detail.DetailMovieResponse;
import com.application.moviecatalog.data.source.remote.response.movie.list.MovieResponse;
import com.application.moviecatalog.data.source.remote.response.movie.list.MovieResultsItem;
import com.application.moviecatalog.data.source.remote.response.tvShow.detail.CreatedByItem;
import com.application.moviecatalog.data.source.remote.response.tvShow.detail.DetailTvShowResponse;
import com.application.moviecatalog.data.source.remote.response.tvShow.detail.NetworksItem;
import com.application.moviecatalog.data.source.remote.response.tvShow.detail.SeasonsItem;
import com.application.moviecatalog.data.source.remote.response.tvShow.list.TvShowResponse;
import com.application.moviecatalog.data.source.remote.response.tvShow.list.TvShowResultsItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieCatalogRepository implements MovieCatalogDataSource {

    private volatile static MovieCatalogRepository INSTANCE = null;

    private final RemoteDataSource remoteDataSource;

    private MovieCatalogRepository(@NonNull RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public static MovieCatalogRepository getInstance(RemoteDataSource dataSource) {
        if (INSTANCE == null) {
            synchronized (MovieCatalogRepository.class) {
                INSTANCE = new MovieCatalogRepository(dataSource);
            }
        }
        return INSTANCE;
    }

    //RemoteDataSourceMovie

    @Override
    public LiveData<List<MovieEntity>> movieEntities() {
        MutableLiveData<List<MovieEntity>> mutableLiveData = new MutableLiveData<>();
        remoteDataSource.callListMovie(movieResponseCall -> movieResponseCall.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(@NonNull Call<MovieResponse> call, @NonNull Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        ArrayList<MovieEntity> movieEntities = new ArrayList<>();
                        if (response.body().getResults() !=null) {
                            for (MovieResultsItem movieResultsItem : response.body().getResults()) {
                                MovieEntity movieEntity = new MovieEntity(
                                        movieResultsItem.getId(),
                                        movieResultsItem.getOriginalLanguage(),
                                        movieResultsItem.getOverview(),
                                        movieResultsItem.getPosterPath(),
                                        movieResultsItem.getReleaseDate(),
                                        movieResultsItem.getTitle(),
                                        movieResultsItem.getVoteAverage()
                                );
                                movieEntities.add(movieEntity);
                            }
                        }
                        mutableLiveData.setValue(movieEntities);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<MovieResponse> call, @NonNull Throwable t) {

            }
        }));
        return mutableLiveData;
    }

    @Override
    public LiveData<DetailMovieEntity> detailMovieEntity(int movieId) {
        MutableLiveData<DetailMovieEntity> mutableLiveData = new MutableLiveData<>();
        remoteDataSource.callDetailListMovie(movieId, movieResponseCall -> movieResponseCall.enqueue(new Callback<DetailMovieResponse>() {
            @Override
            public void onResponse(@NonNull Call<DetailMovieResponse> call, @NonNull Response<DetailMovieResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        DetailMovieEntity detailMovieEntity = null;
                        if (response.body().getId() == movieId) {
                            detailMovieEntity = new DetailMovieEntity(
                                    response.body().isAdult(),
                                    response.body().getBackdropPath(),
                                    response.body().getBelongsToCollection(),
                                    response.body().getBudget(),
                                    response.body().getGenres(),
                                    response.body().getHomepage(),
                                    response.body().getId(),
                                    response.body().getImdbId(),
                                    response.body().getOriginalLanguage(),
                                    response.body().getOriginalTitle(),
                                    response.body().getOverview(),
                                    response.body().getPopularity(),
                                    response.body().getPosterPath(),
                                    response.body().getProductionCompanies(),
                                    response.body().getProductionCountries(),
                                    response.body().getReleaseDate(),
                                    response.body().getRevenue(),
                                    response.body().getRuntime(),
                                    response.body().getSpokenLanguages(),
                                    response.body().getStatus(),
                                    response.body().getTagline(),
                                    response.body().getTitle(),
                                    response.body().isVideo(),
                                    response.body().getVoteAverage(),
                                    response.body().getVoteCount()
                            );
                        }
                        mutableLiveData.setValue(detailMovieEntity);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<DetailMovieResponse> call, @NonNull Throwable t) {

            }
        }));
        return mutableLiveData;
    }

    @Override
    public LiveData<BelongsToCollectionEntity> belongsToCollectionEntity(int movieId) {
        MutableLiveData<BelongsToCollectionEntity> mutableLiveData = new MutableLiveData<>();
        remoteDataSource.callDetailListMovie(movieId, movieDetailResponseCall -> movieDetailResponseCall.enqueue(new Callback<DetailMovieResponse>() {
            @Override
            public void onResponse(@NonNull Call<DetailMovieResponse> call, @NonNull Response<DetailMovieResponse> response) {
                if (response.isSuccessful()){
                    if (response.body() !=null){
                        BelongsToCollectionEntity belongsToCollectionEntity = null;
                        if (response.body().getId() == movieId){
                            if (response.body().getBelongsToCollection() !=null){
                                belongsToCollectionEntity = new BelongsToCollectionEntity(
                                        response.body().getBelongsToCollection().getBackdropPath(),
                                        response.body().getBelongsToCollection().getId(),
                                        response.body().getBelongsToCollection().getName(),
                                        response.body().getBelongsToCollection().getPosterPath()
                                );
                            }
                        }
                        mutableLiveData.setValue(belongsToCollectionEntity);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<DetailMovieResponse> call, @NonNull Throwable t) {

            }
        }));
        return mutableLiveData;
    }

    @Override
    public LiveData<List<GenresEntity>> genresEntityMovie(int movieId) {
        MutableLiveData<List<GenresEntity>> mutableLiveData = new MutableLiveData<>();
        remoteDataSource.callDetailListMovie(movieId, movieDetailResponseCall -> movieDetailResponseCall.enqueue(new Callback<DetailMovieResponse>() {
            @Override
            public void onResponse(@NonNull Call<DetailMovieResponse> call, @NonNull Response<DetailMovieResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        ArrayList<GenresEntity> genresEntities = new ArrayList<>();
                        if (response.body().getGenres() !=null){
                            for (GenresItem genresItem : response.body().getGenres()) {
                                GenresEntity genresEntity = new GenresEntity(
                                        genresItem.getId(),
                                        genresItem.getName()
                                );
                                genresEntities.add(genresEntity);
                            }
                        }
                        mutableLiveData.setValue(genresEntities);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<DetailMovieResponse> call, @NonNull Throwable t) {

            }
        }));

        return mutableLiveData;
    }

    @Override
    public LiveData<List<ProductionCompaniesEntity>> productionCompaniesEntityMovie(int movieId) {
        MutableLiveData<List<ProductionCompaniesEntity>> mutableLiveData = new MutableLiveData<>();
        remoteDataSource.callDetailListMovie(movieId, movieDetailResponseCall -> movieDetailResponseCall.enqueue(new Callback<DetailMovieResponse>() {
            @Override
            public void onResponse(@NonNull Call<DetailMovieResponse> call, @NonNull Response<DetailMovieResponse> response) {
                if (response.isSuccessful()){
                    if (response.body() !=null){
                        ArrayList<ProductionCompaniesEntity> productionCompaniesEntities = new ArrayList<>();
                        if (response.body().getProductionCompanies() !=null){
                            for (ProductionCompaniesItem productionCompaniesItem : response.body().getProductionCompanies()) {
                                ProductionCompaniesEntity productionCompaniesEntity = new ProductionCompaniesEntity(
                                        productionCompaniesItem.getId(),
                                        productionCompaniesItem.getLogoPath(),
                                        productionCompaniesItem.getName(),
                                        productionCompaniesItem.getOriginCountry()
                                );
                                productionCompaniesEntities.add(productionCompaniesEntity);
                            }
                        }
                        mutableLiveData.setValue(productionCompaniesEntities);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<DetailMovieResponse> call, @NonNull Throwable t) {

            }
        }));
        return mutableLiveData;
    }

    @Override
    public LiveData<List<ProductionCountriesEntity>> productionCountriesEntityMovie(int movieId) {
        MutableLiveData<List<ProductionCountriesEntity>> mutableLiveData = new MutableLiveData<>();
        remoteDataSource.callDetailListMovie(movieId, movieDetailResponseCall -> movieDetailResponseCall.enqueue(new Callback<DetailMovieResponse>() {
            @Override
            public void onResponse(@NonNull Call<DetailMovieResponse> call, @NonNull Response<DetailMovieResponse> response) {
                if (response.isSuccessful()){
                    if (response.body() !=null){
                        ArrayList<ProductionCountriesEntity> productionCountriesEntities = new ArrayList<>();
                        if (response.body().getProductionCountries() !=null){
                            for (ProductionCountriesItem productionCountriesItem : response.body().getProductionCountries()){
                                ProductionCountriesEntity productionCountriesEntity = new ProductionCountriesEntity(
                                        productionCountriesItem.getIso31661(),
                                        productionCountriesItem.getName()
                                );
                                productionCountriesEntities.add(productionCountriesEntity);
                            }
                        }
                        mutableLiveData.setValue(productionCountriesEntities);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<DetailMovieResponse> call, @NonNull Throwable t) {

            }
        }));
        return mutableLiveData;
    }

    @Override
    public LiveData<List<SpokenLanguagesEntity>> spokenLanguagesEntityMovie(int movieId) {
        MutableLiveData<List<SpokenLanguagesEntity>> mutableLiveData = new MutableLiveData<>();
        remoteDataSource.callDetailListMovie(movieId, movieDetailResponseCall -> movieDetailResponseCall.enqueue(new Callback<DetailMovieResponse>() {
            @Override
            public void onResponse(@NonNull Call<DetailMovieResponse> call, @NonNull Response<DetailMovieResponse> response) {
                if (response.isSuccessful()){
                    if (response.body() !=null){
                        ArrayList<SpokenLanguagesEntity> spokenLanguagesEntities = new ArrayList<>();
                        if (response.body().getSpokenLanguages() !=null){
                            for (SpokenLanguagesItem spokenLanguagesItem : response.body().getSpokenLanguages()) {
                                SpokenLanguagesEntity spokenLanguagesEntity = new SpokenLanguagesEntity(
                                        spokenLanguagesItem.getIso6391(),
                                        spokenLanguagesItem.getEnglishName(),
                                        spokenLanguagesItem.getName()
                                );
                                spokenLanguagesEntities.add(spokenLanguagesEntity);
                            }
                        }
                        mutableLiveData.setValue(spokenLanguagesEntities);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<DetailMovieResponse> call, @NonNull Throwable t) {

            }
        }));
        return mutableLiveData;
    }

    //RemoteDataSourceTvShow

    @Override
    public LiveData<List<TvShowEntity>> tvShowEntities() {
        MutableLiveData<List<TvShowEntity>> mutableLiveData = new MutableLiveData<>();
        remoteDataSource.callListTvShow(tvShowResponseCall -> tvShowResponseCall.enqueue(new Callback<TvShowResponse>() {
            @Override
            public void onResponse(@NonNull Call<TvShowResponse> call, @NonNull Response<TvShowResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        ArrayList<TvShowEntity> tvShowEntities = new ArrayList<>();
                        if (response.body().getResults() !=null){
                            for (TvShowResultsItem tvShowResultsItem : response.body().getResults()) {
                                TvShowEntity tvShowEntity = new TvShowEntity(
                                        tvShowResultsItem.getFirstAirDate(),
                                        tvShowResultsItem.getId(),
                                        tvShowResultsItem.getName(),
                                        tvShowResultsItem.getOriginalLanguage(),
                                        tvShowResultsItem.getOverview(),
                                        tvShowResultsItem.getPosterPath(),
                                        tvShowResultsItem.getVoteAverage()
                                );
                                tvShowEntities.add(tvShowEntity);
                            }
                        }
                        mutableLiveData.setValue(tvShowEntities);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<TvShowResponse> call, @NonNull Throwable t) {

            }
        }));
        return mutableLiveData;
    }

    @Override
    public LiveData<DetailTvShowEntity> detailTvShowEntity(int tvId) {
        MutableLiveData<DetailTvShowEntity> mutableLiveData = new MutableLiveData<>();
        remoteDataSource.callDetailListTvShow(tvId, tvShowResponseCall -> tvShowResponseCall.enqueue(new Callback<DetailTvShowResponse>() {
            @Override
            public void onResponse(@NonNull Call<DetailTvShowResponse> call, @NonNull Response<DetailTvShowResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        DetailTvShowEntity detailTvShowEntity = null;
                        if (response.body().getId() == tvId) {
                            detailTvShowEntity = new DetailTvShowEntity(
                                    response.body().getBackdropPath(),
                                    response.body().getCreatedBy(),
                                    response.body().getEpisodeRunTime(),
                                    response.body().getFirstAirDate(),
                                    response.body().getGenres(),
                                    response.body().getHomepage(),
                                    response.body().getId(),
                                    response.body().isInProduction(),
                                    response.body().getLanguages(),
                                    response.body().getLastAirDate(),
                                    response.body().getLastEpisodeToAir(),
                                    response.body().getName(),
                                    response.body().getNextEpisodeToAir(),
                                    response.body().getNetworks(),
                                    response.body().getNumberOfEpisodes(),
                                    response.body().getNumberOfSeasons(),
                                    response.body().getOriginCountry(),
                                    response.body().getOriginalLanguage(),
                                    response.body().getOriginalName(),
                                    response.body().getOverview(),
                                    response.body().getPopularity(),
                                    response.body().getPosterPath(),
                                    response.body().getProductionCompanies(),
                                    response.body().getProductionCountries(),
                                    response.body().getSeasons(),
                                    response.body().getSpokenLanguages(),
                                    response.body().getStatus(),
                                    response.body().getTagline(),
                                    response.body().getType(),
                                    response.body().getVoteAverage(),
                                    response.body().getVoteCount()
                            );
                        }
                        mutableLiveData.setValue(detailTvShowEntity);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<DetailTvShowResponse> call, @NonNull Throwable t) {

            }
        }));

        return mutableLiveData;
    }

    @Override
    public LiveData<LastEpisodeToAirEntity> lastEpisodeToAirEntity(int tvId) {
        MutableLiveData<LastEpisodeToAirEntity> mutableLiveData = new MutableLiveData<>();
        remoteDataSource.callDetailListTvShow(tvId, tvShowDetailResponseCall -> tvShowDetailResponseCall.enqueue(new Callback<DetailTvShowResponse>() {
            @Override
            public void onResponse(@NonNull Call<DetailTvShowResponse> call, @NonNull Response<DetailTvShowResponse> response) {
                if (response.isSuccessful()){
                    if (response.body() !=null){
                        LastEpisodeToAirEntity lastEpisodeToAirEntity = null;
                        if (response.body().getId() == tvId) {
                            if (response.body().getLastEpisodeToAir() !=null){
                                lastEpisodeToAirEntity = new LastEpisodeToAirEntity(
                                        response.body().getLastEpisodeToAir().getAirDate(),
                                        response.body().getLastEpisodeToAir().getEpisodeNumber(),
                                        response.body().getLastEpisodeToAir().getId(),
                                        response.body().getLastEpisodeToAir().getName(),
                                        response.body().getLastEpisodeToAir().getOverview(),
                                        response.body().getLastEpisodeToAir().getProductionCode(),
                                        response.body().getLastEpisodeToAir().getSeasonNumber(),
                                        response.body().getLastEpisodeToAir().getStillPath(),
                                        response.body().getLastEpisodeToAir().getVoteAverage(),
                                        response.body().getLastEpisodeToAir().getVoteCount()
                                );
                            }
                        }
                        mutableLiveData.setValue(lastEpisodeToAirEntity);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<DetailTvShowResponse> call, @NonNull Throwable t) {

            }
        }));
        return mutableLiveData;
    }

    @Override
    public LiveData<List<GenresEntity>> genresEntityTvShow(int tvId) {
        MutableLiveData<List<GenresEntity>> mutableLiveData = new MutableLiveData<>();
        remoteDataSource.callDetailListMovie(tvId, movieDetailResponseCall -> movieDetailResponseCall.enqueue(new Callback<DetailMovieResponse>() {
            @Override
            public void onResponse(@NonNull Call<DetailMovieResponse> call, @NonNull Response<DetailMovieResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        ArrayList<GenresEntity> genresEntities = new ArrayList<>();
                        if (response.body().getGenres() !=null){
                            for (GenresItem genresItem : response.body().getGenres()) {
                                GenresEntity genresEntity = new GenresEntity(
                                        genresItem.getId(),
                                        genresItem.getName()
                                );
                                genresEntities.add(genresEntity);
                            }
                        }
                        mutableLiveData.setValue(genresEntities);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<DetailMovieResponse> call, @NonNull Throwable t) {

            }
        }));

        return mutableLiveData;
    }

    @Override
    public LiveData<List<CreatedByEntity>> createdByEntityTvShow(int tvId) {
        MutableLiveData<List<CreatedByEntity>> mutableLiveData = new MutableLiveData<>();
        remoteDataSource.callDetailListTvShow(tvId, tvShowDetailResponseCall -> tvShowDetailResponseCall.enqueue(new Callback<DetailTvShowResponse>() {
            @Override
            public void onResponse(@NonNull Call<DetailTvShowResponse> call, @NonNull Response<DetailTvShowResponse> response) {
                if (response.isSuccessful()){
                    if (response.body() !=null){
                        ArrayList<CreatedByEntity> createdByEntities = new ArrayList<>();
                        if (response.body().getCreatedBy() !=null){
                            for (CreatedByItem createdByItem : response.body().getCreatedBy()){
                                CreatedByEntity createdByEntity = new CreatedByEntity(
                                        createdByItem.getCreditId(),
                                        createdByItem.getGender(),
                                        createdByItem.getId(),
                                        createdByItem.getName(),
                                        createdByItem.getProfilePath(),
                                        createdByItem.getOriginalLanguage()
                                );
                                createdByEntities.add(createdByEntity);
                            }
                        }
                        mutableLiveData.setValue(createdByEntities);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<DetailTvShowResponse> call, @NonNull Throwable t) {

            }
        }));
        return mutableLiveData;
    }

    @Override
    public LiveData<List<ProductionCompaniesEntity>> productionCompaniesEntityTvShow(int tvId) {
        MutableLiveData<List<ProductionCompaniesEntity>> mutableLiveData = new MutableLiveData<>();
        remoteDataSource.callDetailListTvShow(tvId, tvShowDetailResponseCall -> tvShowDetailResponseCall.enqueue(new Callback<DetailTvShowResponse>() {
            @Override
            public void onResponse(@NonNull Call<DetailTvShowResponse> call, @NonNull Response<DetailTvShowResponse> response) {
                if (response.isSuccessful()){
                    if (response.body() !=null){
                        ArrayList<ProductionCompaniesEntity> productionCompaniesEntities = new ArrayList<>();
                        if (response.body().getProductionCompanies() !=null){
                            for (ProductionCompaniesItem productionCompaniesItem : response.body().getProductionCompanies()) {
                                ProductionCompaniesEntity productionCompaniesEntity = new ProductionCompaniesEntity(
                                        productionCompaniesItem.getId(),
                                        productionCompaniesItem.getLogoPath(),
                                        productionCompaniesItem.getName(),
                                        productionCompaniesItem.getOriginCountry()
                                );
                                productionCompaniesEntities.add(productionCompaniesEntity);
                            }
                        }
                        mutableLiveData.setValue(productionCompaniesEntities);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<DetailTvShowResponse> call, @NonNull Throwable t) {

            }
        }));
        return mutableLiveData;
    }

    @Override
    public LiveData<List<NetworksEntity>> networksEntityTvShow(int tvId) {
        MutableLiveData<List<NetworksEntity>> mutableLiveData = new MutableLiveData<>();
        remoteDataSource.callDetailListTvShow(tvId, tvShowDetailResponseCall -> tvShowDetailResponseCall.enqueue(new Callback<DetailTvShowResponse>() {
            @Override
            public void onResponse(@NonNull Call<DetailTvShowResponse> call, @NonNull Response<DetailTvShowResponse> response) {
                if (response.isSuccessful()){
                    if (response.body() !=null){
                        ArrayList<NetworksEntity> networksEntities = new ArrayList<>();
                        if (response.body().getNetworks() !=null){
                            for (NetworksItem networksItem : response.body().getNetworks()){
                                NetworksEntity networksEntity = new NetworksEntity(
                                        networksItem.getId(),
                                        networksItem.getLogoPath(),
                                        networksItem.getName(),
                                        networksItem.getOriginCountry()
                                );
                                networksEntities.add(networksEntity);
                            }
                        }
                        mutableLiveData.setValue(networksEntities);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<DetailTvShowResponse> call, @NonNull Throwable t) {

            }
        }));
        return mutableLiveData;
    }

    @Override
    public LiveData<List<SeasonsEntity>> seasonsEntityTvShow(int tvId) {
        MutableLiveData<List<SeasonsEntity>> mutableLiveData = new MutableLiveData<>();
        remoteDataSource.callDetailListTvShow(tvId, tvShowDetailResponseCall -> tvShowDetailResponseCall.enqueue(new Callback<DetailTvShowResponse>() {
            @Override
            public void onResponse(@NonNull Call<DetailTvShowResponse> call, @NonNull Response<DetailTvShowResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() !=null){
                        ArrayList<SeasonsEntity> seasonsEntities = new ArrayList<>();
                        if (response.body().getSeasons() !=null){
                            for (SeasonsItem seasonsItem : response.body().getSeasons()) {
                                SeasonsEntity seasonsEntity = new SeasonsEntity(
                                        seasonsItem.getAirDate(),
                                        seasonsItem.getEpisodeCount(),
                                        seasonsItem.getId(),
                                        seasonsItem.getName(),
                                        seasonsItem.getOverview(),
                                        seasonsItem.getPosterPath(),
                                        seasonsItem.getSeasonNumber()
                                );
                                seasonsEntities.add(seasonsEntity);
                            }
                        }
                        mutableLiveData.setValue(seasonsEntities);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<DetailTvShowResponse> call, @NonNull Throwable t) {

            }
        }));
        return mutableLiveData;
    }

    @Override
    public LiveData<List<ProductionCountriesEntity>> productionCountriesEntityTvShow(int tvId) {
        MutableLiveData<List<ProductionCountriesEntity>> mutableLiveData = new MutableLiveData<>();
        remoteDataSource.callDetailListTvShow(tvId, tvShowDetailResponseCall -> tvShowDetailResponseCall.enqueue(new Callback<DetailTvShowResponse>() {
            @Override
            public void onResponse(@NonNull Call<DetailTvShowResponse> call, @NonNull Response<DetailTvShowResponse> response) {
                if (response.isSuccessful()){
                    if (response.body() !=null){
                        ArrayList<ProductionCountriesEntity> productionCountriesEntities = new ArrayList<>();
                        if (response.body().getProductionCountries() !=null){
                            for (ProductionCountriesItem productionCountriesItem : response.body().getProductionCountries()){
                                ProductionCountriesEntity productionCountriesEntity = new ProductionCountriesEntity(
                                        productionCountriesItem.getIso31661(),
                                        productionCountriesItem.getName()
                                );
                                productionCountriesEntities.add(productionCountriesEntity);
                            }
                        }
                        mutableLiveData.setValue(productionCountriesEntities);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<DetailTvShowResponse> call, @NonNull Throwable t) {

            }
        }));
        return mutableLiveData;
    }

    @Override
    public LiveData<List<SpokenLanguagesEntity>> spokenLanguagesEntityTvShow(int tvId) {
        MutableLiveData<List<SpokenLanguagesEntity>> mutableLiveData = new MutableLiveData<>();
        remoteDataSource.callDetailListTvShow(tvId, tvShowDetailResponseCall -> tvShowDetailResponseCall.enqueue(new Callback<DetailTvShowResponse>() {
            @Override
            public void onResponse(@NonNull Call<DetailTvShowResponse> call, @NonNull Response<DetailTvShowResponse> response) {
                if (response.isSuccessful()){
                    if (response.body() !=null){
                        ArrayList<SpokenLanguagesEntity> spokenLanguagesEntities = new ArrayList<>();
                        if (response.body().getSpokenLanguages() !=null){
                            for (SpokenLanguagesItem spokenLanguagesItem : response.body().getSpokenLanguages()) {
                                SpokenLanguagesEntity spokenLanguagesEntity = new SpokenLanguagesEntity(
                                        spokenLanguagesItem.getIso6391(),
                                        spokenLanguagesItem.getEnglishName(),
                                        spokenLanguagesItem.getName()
                                );
                                spokenLanguagesEntities.add(spokenLanguagesEntity);
                            }
                        }
                        mutableLiveData.setValue(spokenLanguagesEntities);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<DetailTvShowResponse> call, @NonNull Throwable t) {

            }
        }));
        return mutableLiveData;
    }
}