package com.application.moviecatalog.data.source.local.entity.movie.detail;

public class BelongsToCollectionEntity {

	private String backdropPath;
	private int id;
	private String name;
	private String posterPath;

	public BelongsToCollectionEntity(String backdropPath, int id, String name, String posterPath) {
		this.backdropPath = backdropPath;
		this.id = id;
		this.name = name;
		this.posterPath = posterPath;
	}

	public void setBackdropPath(String backdropPath){
		this.backdropPath = backdropPath;
	}

	public String getBackdropPath(){
		return backdropPath;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setPosterPath(String posterPath){
		this.posterPath = posterPath;
	}

	public String getPosterPath(){
		return posterPath;
	}
}