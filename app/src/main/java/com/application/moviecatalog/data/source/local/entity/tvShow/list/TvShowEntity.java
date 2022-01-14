package com.application.moviecatalog.data.source.local.entity.tvShow.list;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShowEntity implements Parcelable {

	private String firstAirDate;
	private int id;
	private String name;
	private String originalLanguage;
	private String overview;
	private String posterPath;
	private double voteAverage;

	public TvShowEntity() {
	}

	public TvShowEntity(String firstAirDate, int id, String name, String originalLanguage, String overview, String posterPath, double voteAverage) {
		this.firstAirDate = firstAirDate;
		this.id = id;
		this.name = name;
		this.originalLanguage = originalLanguage;
		this.overview = overview;
		this.posterPath = posterPath;
		this.voteAverage = voteAverage;
	}

	protected TvShowEntity(Parcel in) {
		firstAirDate = in.readString();
		id = in.readInt();
		name = in.readString();
		originalLanguage = in.readString();
		overview = in.readString();
		posterPath = in.readString();
		voteAverage = in.readDouble();
	}

	public static final Creator<TvShowEntity> CREATOR = new Creator<TvShowEntity>() {
		@Override
		public TvShowEntity createFromParcel(Parcel in) {
			return new TvShowEntity(in);
		}

		@Override
		public TvShowEntity[] newArray(int size) {
			return new TvShowEntity[size];
		}
	};

	public String getFirstAirDate() {
		return firstAirDate;
	}

	public void setFirstAirDate(String firstAirDate) {
		this.firstAirDate = firstAirDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		dest.writeString(firstAirDate);
		dest.writeInt(id);
		dest.writeString(name);
		dest.writeString(originalLanguage);
		dest.writeString(overview);
		dest.writeString(posterPath);
		dest.writeDouble(voteAverage);
	}
}