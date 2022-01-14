package com.application.moviecatalog.data.source.remote.response;

import com.google.gson.annotations.SerializedName;

public class GenresItem{

	@SerializedName("id")
	private int id;

	@SerializedName("name")
	private String name;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}