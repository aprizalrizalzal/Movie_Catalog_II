package com.application.moviecatalog.data.source.remote.response.tvShow.detail;

import com.application.moviecatalog.data.source.remote.response.GenresItem;
import com.application.moviecatalog.data.source.remote.response.ProductionCompaniesItem;
import com.application.moviecatalog.data.source.remote.response.ProductionCountriesItem;
import com.application.moviecatalog.data.source.remote.response.SpokenLanguagesItem;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailTvShowResponse{

	@SerializedName("backdrop_path")
	private String backdropPath;

	@SerializedName("created_by")
	private List<CreatedByItem> createdBy;

	@SerializedName("episode_run_time")
	private List<Integer> episodeRunTime;

	@SerializedName("first_air_date")
	private String firstAirDate;

	@SerializedName("genres")
	private List<GenresItem> genres;

	@SerializedName("homepage")
	private String homepage;

	@SerializedName("id")
	private int id;

	@SerializedName("in_production")
	private boolean inProduction;

	@SerializedName("languages")
	private List<String> languages;

	@SerializedName("last_air_date")
	private String lastAirDate;

	@SerializedName("last_episode_to_air")
	private LastEpisodeToAir lastEpisodeToAir;

	@SerializedName("name")
	private String name;

	@SerializedName("next_episode_to_air")
	private Object nextEpisodeToAir;

	@SerializedName("networks")
	private List<NetworksItem> networks;

	@SerializedName("number_of_episodes")
	private int numberOfEpisodes;

	@SerializedName("number_of_seasons")
	private int numberOfSeasons;

	@SerializedName("origin_country")
	private List<String> originCountry;

	@SerializedName("original_language")
	private String originalLanguage;

	@SerializedName("original_name")
	private String originalName;

	@SerializedName("overview")
	private String overview;

	@SerializedName("popularity")
	private double popularity;

	@SerializedName("poster_path")
	private String posterPath;

	@SerializedName("production_companies")
	private List<ProductionCompaniesItem> productionCompanies;

	@SerializedName("production_countries")
	private List<ProductionCountriesItem> productionCountries;

	@SerializedName("seasons")
	private List<SeasonsItem> seasons;

	@SerializedName("spoken_languages")
	private List<SpokenLanguagesItem> spokenLanguages;

	@SerializedName("status")
	private String status;

	@SerializedName("tagline")
	private String tagline;

	@SerializedName("type")
	private String type;

	@SerializedName("vote_average")
	private double voteAverage;

	@SerializedName("vote_count")
	private int voteCount;

	public String getBackdropPath() {
		return backdropPath;
	}

	public List<CreatedByItem> getCreatedBy() {
		return createdBy;
	}

	public List<Integer> getEpisodeRunTime() {
		return episodeRunTime;
	}

	public String getFirstAirDate() {
		return firstAirDate;
	}

	public List<GenresItem> getGenres() {
		return genres;
	}

	public String getHomepage() {
		return homepage;
	}

	public int getId() {
		return id;
	}

	public boolean isInProduction() {
		return inProduction;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public String getLastAirDate() {
		return lastAirDate;
	}

	public LastEpisodeToAir getLastEpisodeToAir() {
		return lastEpisodeToAir;
	}

	public String getName() {
		return name;
	}

	public Object getNextEpisodeToAir() {
		return nextEpisodeToAir;
	}

	public List<NetworksItem> getNetworks() {
		return networks;
	}

	public int getNumberOfEpisodes() {
		return numberOfEpisodes;
	}

	public int getNumberOfSeasons() {
		return numberOfSeasons;
	}

	public List<String> getOriginCountry() {
		return originCountry;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public String getOriginalName() {
		return originalName;
	}

	public String getOverview() {
		return overview;
	}

	public double getPopularity() {
		return popularity;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public List<ProductionCompaniesItem> getProductionCompanies() {
		return productionCompanies;
	}

	public List<ProductionCountriesItem> getProductionCountries() {
		return productionCountries;
	}

	public List<SeasonsItem> getSeasons() {
		return seasons;
	}

	public List<SpokenLanguagesItem> getSpokenLanguages() {
		return spokenLanguages;
	}

	public String getStatus() {
		return status;
	}

	public String getTagline() {
		return tagline;
	}

	public String getType() {
		return type;
	}

	public double getVoteAverage() {
		return voteAverage;
	}

	public int getVoteCount() {
		return voteCount;
	}

}