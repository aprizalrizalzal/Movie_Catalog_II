package com.application.moviecatalog.data.source.remote.response.movie.detail;

import com.google.gson.annotations.SerializedName;

public class BelongsToCollection{

	@SerializedName("backdrop_path")
	private String backdropPath;

	@SerializedName("id")
	private int id;

	@SerializedName("name")
	private String name;

	@SerializedName("poster_path")
	private String posterPath;

	public String getBackdropPath(){
		return backdropPath;
	}

	public int getId(){
		return id;
	}

	public String getName(){
		return name;
	}

	public String getPosterPath(){
		return posterPath;
	}
}