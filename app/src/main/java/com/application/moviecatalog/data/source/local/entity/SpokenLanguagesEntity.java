package com.application.moviecatalog.data.source.local.entity;

public class SpokenLanguagesEntity {

	private String iso6391;
	private String englishName;
	private String name;

	public SpokenLanguagesEntity(String iso6391, String englishName, String name) {
		this.iso6391 = iso6391;
		this.englishName = englishName;
		this.name = name;
	}

	public String getIso6391() {
		return iso6391;
	}

	public void setIso6391(String iso6391) {
		this.iso6391 = iso6391;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}