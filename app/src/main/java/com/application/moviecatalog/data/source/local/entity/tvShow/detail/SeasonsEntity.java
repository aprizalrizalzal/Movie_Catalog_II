package com.application.moviecatalog.data.source.local.entity.tvShow.detail;

public class SeasonsEntity {

	private String airDate;
	private int episodeCount;
	private int id;
	private String name;
	private String overview;
	private String posterPath;
	private int seasonNumber;

	public SeasonsEntity(String airDate, int episodeCount, int id, String name, String overview, String posterPath, int seasonNumber) {
		this.airDate = airDate;
		this.episodeCount = episodeCount;
		this.id = id;
		this.name = name;
		this.overview = overview;
		this.posterPath = posterPath;
		this.seasonNumber = seasonNumber;
	}

	public String getAirDate() {
		return airDate;
	}

	public void setAirDate(String airDate) {
		this.airDate = airDate;
	}

	public int getEpisodeCount() {
		return episodeCount;
	}

	public void setEpisodeCount(int episodeCount) {
		this.episodeCount = episodeCount;
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

	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	public int getSeasonNumber() {
		return seasonNumber;
	}

	public void setSeasonNumber(int seasonNumber) {
		this.seasonNumber = seasonNumber;
	}
}