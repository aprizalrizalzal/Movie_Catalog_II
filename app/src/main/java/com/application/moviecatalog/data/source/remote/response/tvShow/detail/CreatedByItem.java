package com.application.moviecatalog.data.source.remote.response.tvShow.detail;

import com.google.gson.annotations.SerializedName;

public class CreatedByItem{

	@SerializedName("credit_id")
	private String creditId;

	@SerializedName("gender")
	private int gender;

	@SerializedName("id")
	private int id;

	@SerializedName("name")
	private String name;

	@SerializedName("profile_path")
	private String profilePath;

	@SerializedName("original_language")
	private String originalLanguage;

	public String getCreditId() {
		return creditId;
	}

	public int getGender() {
		return gender;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getProfilePath() {
		return profilePath;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

}