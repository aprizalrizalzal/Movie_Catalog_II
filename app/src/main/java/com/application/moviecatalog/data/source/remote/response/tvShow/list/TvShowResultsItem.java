package com.application.moviecatalog.data.source.remote.response.tvShow.list;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TvShowResultsItem implements Parcelable {

	@SerializedName("backdrop_path")
	private final String backdropPath;

	@SerializedName("first_air_date")
	private final String firstAirDate;

	@SerializedName("genre_ids")
	private List<Integer> genreIds;

	@SerializedName("id")
	private final int id;

	@SerializedName("name")
	private final String name;

	@SerializedName("origin_country")
	private final List<String> originCountry;

	@SerializedName("original_language")
	private final String originalLanguage;

	@SerializedName("original_name")
	private final String originalName;

	@SerializedName("overview")
	private final String overview;

	@SerializedName("popularity")
	private final double popularity;

	@SerializedName("poster_path")
	private final String posterPath;

	@SerializedName("vote_average")
	private final double voteAverage;

	@SerializedName("vote_count")
	private final int voteCount;

	protected TvShowResultsItem(Parcel in) {
		backdropPath = in.readString();
		firstAirDate = in.readString();
		id = in.readInt();
		name = in.readString();
		originCountry = in.createStringArrayList();
		originalLanguage = in.readString();
		originalName = in.readString();
		overview = in.readString();
		popularity = in.readDouble();
		posterPath = in.readString();
		voteAverage = in.readDouble();
		voteCount = in.readInt();
	}

	public static final Creator<TvShowResultsItem> CREATOR = new Creator<TvShowResultsItem>() {
		@Override
		public TvShowResultsItem createFromParcel(Parcel in) {
			return new TvShowResultsItem(in);
		}

		@Override
		public TvShowResultsItem[] newArray(int size) {
			return new TvShowResultsItem[size];
		}
	};

	public String getBackdropPath() {
		return backdropPath;
	}

	public String getFirstAirDate() {
		return firstAirDate;
	}

	public List<Integer> getGenreIds() {
		return genreIds;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<String> getOriginCountry() {
		return originCountry;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public String getOriginalName() {
		return originalName;
	}

	public String getOverview() {
		return overview;
	}

	public double getPopularity() {
		return popularity;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public double getVoteAverage() {
		return voteAverage;
	}

	public int getVoteCount() {
		return voteCount;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(backdropPath);
		dest.writeString(firstAirDate);
		dest.writeInt(id);
		dest.writeString(name);
		dest.writeStringList(originCountry);
		dest.writeString(originalLanguage);
		dest.writeString(originalName);
		dest.writeString(overview);
		dest.writeDouble(popularity);
		dest.writeString(posterPath);
		dest.writeDouble(voteAverage);
		dest.writeInt(voteCount);
	}
}