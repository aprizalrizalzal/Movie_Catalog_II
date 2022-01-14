package com.application.moviecatalog.data.source.local.entity.movie.list;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieEntity implements Parcelable {

	private int id;
	private String originalLanguage;
	private String overview;
	private String posterPath;
	private String releaseDate;
	private String title;
	private double voteAverage;

	public MovieEntity(int id, String originalLanguage, String overview, String posterPath, String releaseDate, String title, double voteAverage) {
		this.id = id;
		this.originalLanguage = originalLanguage;
		this.overview = overview;
		this.posterPath = posterPath;
		this.releaseDate = releaseDate;
		this.title = title;
		this.voteAverage = voteAverage;
	}

	protected MovieEntity(Parcel in) {
		id = in.readInt();
		originalLanguage = in.readString();
		overview = in.readString();
		posterPath = in.readString();
		releaseDate = in.readString();
		title = in.readString();
		voteAverage = in.readDouble();
	}

	public static final Creator<MovieEntity> CREATOR = new Creator<MovieEntity>() {
		@Override
		public MovieEntity createFromParcel(Parcel in) {
			return new MovieEntity(in);
		}

		@Override
		public MovieEntity[] newArray(int size) {
			return new MovieEntity[size];
		}
	};

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getVoteAverage() {
		return voteAverage;
	}

	public void setVoteAverage(double voteAverage) {
		this.voteAverage = voteAverage;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(id);
		dest.writeString(originalLanguage);
		dest.writeString(overview);
		dest.writeString(posterPath);
		dest.writeString(releaseDate);
		dest.writeString(title);
		dest.writeDouble(voteAverage);
	}
}