package com.application.moviecatalog.data.source.local.entity.tvShow.detail;

public class NetworksEntity {

	private int id;
	private String logoPath;
	private String name;
	private String originCountry;

	public NetworksEntity(int id, String logoPath, String name, String originCountry) {
		this.id = id;
		this.logoPath = logoPath;
		this.name = name;
		this.originCountry = originCountry;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOriginCountry() {
		return originCountry;
	}

	public void setOriginCountry(String originCountry) {
		this.originCountry = originCountry;
	}
}