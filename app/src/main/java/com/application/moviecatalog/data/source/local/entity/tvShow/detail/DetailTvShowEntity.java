package com.application.moviecatalog.data.source.local.entity.tvShow.detail;

import com.application.moviecatalog.data.source.remote.response.GenresItem;
import com.application.moviecatalog.data.source.remote.response.ProductionCompaniesItem;
import com.application.moviecatalog.data.source.remote.response.ProductionCountriesItem;
import com.application.moviecatalog.data.source.remote.response.SpokenLanguagesItem;
import com.application.moviecatalog.data.source.remote.response.tvShow.detail.CreatedByItem;
import com.application.moviecatalog.data.source.remote.response.tvShow.detail.LastEpisodeToAir;
import com.application.moviecatalog.data.source.remote.response.tvShow.detail.NetworksItem;
import com.application.moviecatalog.data.source.remote.response.tvShow.detail.SeasonsItem;

import java.util.List;

public class DetailTvShowEntity {
    private String backdropPath;
    private List<CreatedByItem> createdBy;
    private List<Integer> episodeRunTime;
    private String firstAirDate;
    private List<GenresItem> genres;
    private String homepage;
    private int id;
    private boolean inProduction;
    private List<String> languages;
    private String lastAirDate;
    private LastEpisodeToAir lastEpisodeToAir;
    private String name;
    private Object nextEpisodeToAir;
    private List<NetworksItem> networks;
    private int numberOfEpisodes;
    private int numberOfSeasons;
    private List<String> originCountry;
    private String originalLanguage;
    private String originalName;
    private String overview;
    private double popularity;
    private String posterPath;
    private List<ProductionCompaniesItem> productionCompanies;
    private List<ProductionCountriesItem> productionCountries;
    private List<SeasonsItem> seasons;
    private List<SpokenLanguagesItem> spokenLanguages;
    private String status;
    private String tagline;
    private String type;
    private double voteAverage;
    private int voteCount;

    public DetailTvShowEntity(String backdropPath, List<CreatedByItem> createdBy, List<Integer> episodeRunTime, String firstAirDate, List<GenresItem> genres, String homepage, int id, boolean inProduction, List<String> languages, String lastAirDate, LastEpisodeToAir lastEpisodeToAir, String name, Object nextEpisodeToAir, List<NetworksItem> networks, int numberOfEpisodes, int numberOfSeasons, List<String> originCountry, String originalLanguage, String originalName, String overview, double popularity, String posterPath, List<ProductionCompaniesItem> productionCompanies, List<ProductionCountriesItem> productionCountries, List<SeasonsItem> seasons, List<SpokenLanguagesItem> spokenLanguages, String status, String tagline, String type, double voteAverage, int voteCount) {
        this.backdropPath = backdropPath;
        this.createdBy = createdBy;
        this.episodeRunTime = episodeRunTime;
        this.firstAirDate = firstAirDate;
        this.genres = genres;
        this.homepage = homepage;
        this.id = id;
        this.inProduction = inProduction;
        this.languages = languages;
        this.lastAirDate = lastAirDate;
        this.lastEpisodeToAir = lastEpisodeToAir;
        this.name = name;
        this.nextEpisodeToAir = nextEpisodeToAir;
        this.networks = networks;
        this.numberOfEpisodes = numberOfEpisodes;
        this.numberOfSeasons = numberOfSeasons;
        this.originCountry = originCountry;
        this.originalLanguage = originalLanguage;
        this.originalName = originalName;
        this.overview = overview;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.productionCompanies = productionCompanies;
        this.productionCountries = productionCountries;
        this.seasons = seasons;
        this.spokenLanguages = spokenLanguages;
        this.status = status;
        this.tagline = tagline;
        this.type = type;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public List<CreatedByItem> getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(List<CreatedByItem> createdBy) {
        this.createdBy = createdBy;
    }

    public List<Integer> getEpisodeRunTime() {
        return episodeRunTime;
    }

    public void setEpisodeRunTime(List<Integer> episodeRunTime) {
        this.episodeRunTime = episodeRunTime;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public List<GenresItem> getGenres() {
        return genres;
    }

    public void setGenres(List<GenresItem> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isInProduction() {
        return inProduction;
    }

    public void setInProduction(boolean inProduction) {
        this.inProduction = inProduction;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getLastAirDate() {
        return lastAirDate;
    }

    public void setLastAirDate(String lastAirDate) {
        this.lastAirDate = lastAirDate;
    }

    public LastEpisodeToAir getLastEpisodeToAir() {
        return lastEpisodeToAir;
    }

    public void setLastEpisodeToAir(LastEpisodeToAir lastEpisodeToAir) {
        this.lastEpisodeToAir = lastEpisodeToAir;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getNextEpisodeToAir() {
        return nextEpisodeToAir;
    }

    public void setNextEpisodeToAir(Object nextEpisodeToAir) {
        this.nextEpisodeToAir = nextEpisodeToAir;
    }

    public List<NetworksItem> getNetworks() {
        return networks;
    }

    public void setNetworks(List<NetworksItem> networks) {
        this.networks = networks;
    }

    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    public void setNumberOfEpisodes(int numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(int numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public List<String> getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(List<String> originCountry) {
        this.originCountry = originCountry;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public List<ProductionCompaniesItem> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<ProductionCompaniesItem> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public List<ProductionCountriesItem> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(List<ProductionCountriesItem> productionCountries) {
        this.productionCountries = productionCountries;
    }

    public List<SeasonsItem> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<SeasonsItem> seasons) {
        this.seasons = seasons;
    }

    public List<SpokenLanguagesItem> getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(List<SpokenLanguagesItem> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
}
