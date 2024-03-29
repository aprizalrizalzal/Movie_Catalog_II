package com.application.moviecatalog.data.source.local.entity.tvShow.detail;

public class LastEpisodeToAirEntity {

	private String airDate;
	private int episodeNumber;
	private int id;
	private String name;
	private String overview;
	private String productionCode;
	private int seasonNumber;
	private String stillPath;
	private double voteAverage;
	private int voteCount;

	public LastEpisodeToAirEntity(String airDate, int episodeNumber, int id, String name, String overview, String productionCode, int seasonNumber, String stillPath, double voteAverage, int voteCount) {
		this.airDate = airDate;
		this.episodeNumber = episodeNumber;
		this.id = id;
		this.name = name;
		this.overview = overview;
		this.productionCode = productionCode;
		this.seasonNumber = seasonNumber;
		this.stillPath = stillPath;
		this.voteAverage = voteAverage;
		this.voteCount = voteCount;
	}

	public String getAirDate() {
		return airDate;
	}

	public void setAirDate(String airDate) {
		this.airDate = airDate;
	}

	public int getEpisodeNumber() {
		return episodeNumber;
	}

	public void setEpisodeNumber(int episodeNumber) {
		this.episodeNumber = episodeNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getProductionCode() {
		return productionCode;
	}

	public void setProductionCode(String productionCode) {
		this.productionCode = productionCode;
	}

	public int getSeasonNumber() {
		return seasonNumber;
	}

	public void setSeasonNumber(int seasonNumber) {
		this.seasonNumber = seasonNumber;
	}

	public String getStillPath() {
		return stillPath;
	}

	public void setStillPath(String stillPath) {
		this.stillPath = stillPath;
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