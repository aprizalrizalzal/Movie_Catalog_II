package com.application.moviecatalog.data.source.remote.response.movie.detail;

import android.os.Parcel;
import android.os.Parcelable;

import com.application.moviecatalog.data.source.remote.response.GenresItem;
import com.application.moviecatalog.data.source.remote.response.ProductionCompaniesItem;
import com.application.moviecatalog.data.source.remote.response.ProductionCountriesItem;
import com.application.moviecatalog.data.source.remote.response.SpokenLanguagesItem;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailMovieResponse implements Parcelable {

	@SerializedName("adult")
	private final boolean adult;

	@SerializedName("backdrop_path")
	private final String backdropPath;

	@SerializedName("belongs_to_collection")
	private BelongsToCollection belongsToCollection;

	@SerializedName("budget")
	private final int budget;

	@SerializedName("genres")
	private List<GenresItem> genres;

	@SerializedName("homepage")
	private final String homepage;

	@SerializedName("id")
	private final int id;

	@SerializedName("imdb_id")
	private final String imdbId;

	@SerializedName("original_language")
	private final String originalLanguage;

	@SerializedName("original_title")
	private final String originalTitle;

	@SerializedName("overview")
	private final String overview;

	@SerializedName("popularity")
	private final double popularity;

	@SerializedName("poster_path")
	private final String posterPath;

	@SerializedName("production_companies")
	private List<ProductionCompaniesItem> productionCompanies;

	@SerializedName("production_countries")
	private List<ProductionCountriesItem> productionCountries;

	@SerializedName("release_date")
	private final String releaseDate;

	@SerializedName("revenue")
	private final int revenue;

	@SerializedName("runtime")
	private final int runtime;

	@SerializedName("spoken_languages")
	private List<SpokenLanguagesItem> spokenLanguages;

	@SerializedName("status")
	private final String status;

	@SerializedName("tagline")
	private final String tagline;

	@SerializedName("title")
	private final String title;

	@SerializedName("video")
	private final boolean video;

	@SerializedName("vote_average")
	private final double voteAverage;

	@SerializedName("vote_count")
	private final int voteCount;

	protected DetailMovieResponse(Parcel in) {
		adult = in.readByte() != 0;
		backdropPath = in.readString();
		budget = in.readInt();
		homepage = in.readString();
		id = in.readInt();
		imdbId = in.readString();
		originalLanguage = in.readString();
		originalTitle = in.readString();
		overview = in.readString();
		popularity = in.readDouble();
		posterPath = in.readString();
		releaseDate = in.readString();
		revenue = in.readInt();
		runtime = in.readInt();
		status = in.readString();
		tagline = in.readString();
		title = in.readString();
		video = in.readByte() != 0;
		voteAverage = in.readDouble();
		voteCount = in.readInt();
	}

	public static final Creator<DetailMovieResponse> CREATOR = new Creator<DetailMovieResponse>() {
		@Override
		public DetailMovieResponse createFromParcel(Parcel in) {
			return new DetailMovieResponse(in);
		}

		@Override
		public DetailMovieResponse[] newArray(int size) {
			return new DetailMovieResponse[size];
		}
	};

	public boolean isAdult() {
		return adult;
	}

	public String getBackdropPath() {
		return backdropPath;
	}

	public BelongsToCollection getBelongsToCollection() {
		return belongsToCollection;
	}

	public int getBudget() {
		return budget;
	}

	public List<GenresItem> getGenres() {
		return genres;
	}

	public String getHomepage() {
		return homepage;
	}

	public int getId() {
		return id;
	}

	public String getImdbId() {
		return imdbId;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public String getOriginalTitle() {
		return originalTitle;
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

	public List<ProductionCompaniesItem> getProductionCompanies() {
		return productionCompanies;
	}

	public List<ProductionCountriesItem> getProductionCountries() {
		return productionCountries;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public int getRevenue() {
		return revenue;
	}

	public int getRuntime() {
		return runtime;
	}

	public List<SpokenLanguagesItem> getSpokenLanguages() {
		return spokenLanguages;
	}

	public String getStatus() {
		return status;
	}

	public String getTagline() {
		return tagline;
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
		dest.writeInt(budget);
		dest.writeString(homepage);
		dest.writeInt(id);
		dest.writeString(imdbId);
		dest.writeString(originalLanguage);
		dest.writeString(originalTitle);
		dest.writeString(overview);
		dest.writeDouble(popularity);
		dest.writeString(posterPath);
		dest.writeString(releaseDate);
		dest.writeInt(revenue);
		dest.writeInt(runtime);
		dest.writeString(status);
		dest.writeString(tagline);
		dest.writeString(title);
		dest.writeByte((byte) (video ? 1 : 0));
		dest.writeDouble(voteAverage);
		dest.writeInt(voteCount);
	}
}