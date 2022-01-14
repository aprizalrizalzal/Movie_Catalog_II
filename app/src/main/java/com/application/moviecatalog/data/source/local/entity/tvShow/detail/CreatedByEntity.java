package com.application.moviecatalog.data.source.local.entity.tvShow.detail;

public class CreatedByEntity {

	private String creditId;
	private int gender;
	private int id;
	private String name;
	private String profilePath;
	private String originalLanguage;

	public CreatedByEntity(String creditId, int gender, int id, String name, String profilePath, String originalLanguage) {
		this.creditId = creditId;
		this.gender = gender;
		this.id = id;
		this.name = name;
		this.profilePath = profilePath;
		this.originalLanguage = originalLanguage;
	}

	public String getCreditId() {
		return creditId;
	}

	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
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

	public String getProfilePath() {
		return profilePath;
	}

	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}
}