package com.application.moviecatalog.data.source.remote.response;

import com.google.gson.annotations.SerializedName;

public class SpokenLanguagesItem{

	@SerializedName("iso_639_1")
	private String iso6391;

	@SerializedName("english_name")
	private String englishName;

	@SerializedName("name")
	private String name;

	public String getIso6391() {
		return iso6391;
	}

	public String getEnglishName() {
		return englishName;
	}

	public String getName() {
		return name;
	}

}