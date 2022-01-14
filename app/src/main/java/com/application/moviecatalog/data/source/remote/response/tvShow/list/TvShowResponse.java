package com.application.moviecatalog.data.source.remote.response.tvShow.list;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TvShowResponse {

	@SerializedName("page")
	private int page;

	@SerializedName("total_pages")
	private int totalPages;

	@SerializedName("results")
	private List<TvShowResultsItem> results;

	@SerializedName("total_results")
	private int totalResults;

	public int getPage(){
		return page;
	}

	public int getTotalPages(){
		return totalPages;
	}

	public List<TvShowResultsItem> getResults(){
		return results;
	}

	public int getTotalResults(){
		return totalResults;
	}
}