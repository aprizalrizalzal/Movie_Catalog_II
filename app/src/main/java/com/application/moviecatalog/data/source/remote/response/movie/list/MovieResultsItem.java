package com.application.moviecatalog.data.source.remote.response.movie.list;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResultsItem implements Parcelable {

	@SerializedName("adult")
	private final boolean adult;

	@SerializedName("backdrop_path")
	private final String backdropPath;

	@SerializedName("genre_ids")
	private List<Integer> genreIds;

	@SerializedName("id")
	private final int id;

	@SerializedName("original_title")
	private final String originalTitle;

	@SerializedName("original_language")
	private final String originalLanguage;

	@SerializedName("overview")
	private final String overview;

	@SerializedName("popularity")
	private final double popularity;

	@SerializedName("poster_path")
	private final String posterPath;

	@SerializedName("release_date")
	private final String releaseDate;

	@SerializedName("title")
	private final String title;

	@SerializedName("video")
	private final boolean video;

	@SerializedName("vote_average")
	private final double voteAverage;

	@SerializedName("vote_count")
	private final int voteCount;

	protected MovieResultsItem(Parcel in) {
		adult = in.readByte() != 0;
		backdropPath = in.readString();
		id = in.readInt();
		originalTitle = in.readString();
		originalLanguage = in.readString();
		overview = in.readString();
		popularity = in.readDouble();
		posterPath = in.readString();
		releaseDate = in.readString();
		title = in.readString();
		video = in.readByte() != 0;
		voteAverage = in.readDouble();
		voteCount = in.readInt();
	}

	public static final Creator<MovieResultsItem> CREATOR = new Creator<MovieResultsItem>() {
		@Override
		public MovieResultsItem createFromParcel(Parcel in) {
			return new MovieResultsItem(in);
		}

		@Override
		public MovieResultsItem[] newArray(int size) {
			return new MovieResultsItem[size];
		}
	};

	public boolean isAdult() {
		return adult;
	}

	public String getBackdropPath() {
		return backdropPath;
	}

	public List<Integer> getGenreIds() {
		return genreIds;
	}

	public int getId() {
		return id;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
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

	public String getReleaseDate() {
		return releaseDate;
	}

	public String getTitle() {
		return title;
	}

	public boolean isVideo() {
		return video;
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
		dest.writeByte((byte) (adult ? 1 : 0));
		dest.writeString(backdropPath);
		dest.writeInt(id);
		dest.writeString(originalTitle);
		dest.writeString(originalLanguage);
		dest.writeString(overview);
		dest.writeDouble(popularity);
		dest.writeString(posterPath);
		dest.writeString(releaseDate);
		dest.writeString(title);
		dest.writeByte((byte) (video ? 1 : 0));
		dest.writeDouble(voteAverage);
		dest.writeInt(voteCount);
	}
}