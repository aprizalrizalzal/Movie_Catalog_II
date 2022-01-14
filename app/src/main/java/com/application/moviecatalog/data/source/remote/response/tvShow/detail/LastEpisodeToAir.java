package com.application.moviecatalog.data.source.remote.response.tvShow.detail;

import com.google.gson.annotations.SerializedName;

public class LastEpisodeToAir{

	@SerializedName("air_date")
	private String airDate;

	@SerializedName("episode_number")
	private int episodeNumber;

	@SerializedName("id")
	private int id;

	@SerializedName("name")
	private String name;

	@SerializedName("overview")
	private String overview;

	@SerializedName("production_code")
	private String productionCode;

	@SerializedName("season_number")
	private int seasonNumber;

	@SerializedName("still_path")
	private String stillPath;

	@SerializedName("vote_average")
	private double voteAverage;

	@SerializedName("vote_count")
	private int voteCount;

	public String getAirDate() {
		return airDate;
	}

	public int getEpisodeNumber() {
		return episodeNumber;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getOverview() {
		return overview;
	}

	public String getProductionCode() {
		return productionCode;
	}

	public int getSeasonNumber() {
		return seasonNumber;
	}

	public String getStillPath() {
		return stillPath;
	}

	public double getVoteAverage() {
		return voteAverage;
	}

	public int getVoteCount() {
		return voteCount;
	}

}