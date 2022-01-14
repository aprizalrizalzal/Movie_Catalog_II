package com.application.moviecatalog.ui.detail;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.application.moviecatalog.R;
import com.application.moviecatalog.data.source.local.entity.GenresEntity;
import com.application.moviecatalog.data.source.local.entity.ProductionCompaniesEntity;
import com.application.moviecatalog.data.source.local.entity.ProductionCountriesEntity;
import com.application.moviecatalog.data.source.local.entity.SpokenLanguagesEntity;
import com.application.moviecatalog.data.source.local.entity.movie.detail.BelongsToCollectionEntity;
import com.application.moviecatalog.data.source.local.entity.movie.detail.DetailMovieEntity;
import com.application.moviecatalog.data.source.local.entity.movie.list.MovieEntity;
import com.application.moviecatalog.data.source.local.entity.tvShow.detail.CreatedByEntity;
import com.application.moviecatalog.data.source.local.entity.tvShow.detail.DetailTvShowEntity;
import com.application.moviecatalog.data.source.local.entity.tvShow.detail.LastEpisodeToAirEntity;
import com.application.moviecatalog.data.source.local.entity.tvShow.detail.NetworksEntity;
import com.application.moviecatalog.data.source.local.entity.tvShow.detail.SeasonsEntity;
import com.application.moviecatalog.data.source.local.entity.tvShow.list.TvShowEntity;
import com.application.moviecatalog.data.source.MovieCatalogRepository;
import com.application.moviecatalog.data.source.remote.RemoteDataSource;
import com.application.moviecatalog.databinding.ActivityDetailListBinding;
import com.application.moviecatalog.databinding.ItemsBelongToCollectionBinding;
import com.application.moviecatalog.databinding.ItemsDetailMovieOrTvShowBinding;
import com.application.moviecatalog.databinding.ItemsLastEpisodeToAirBinding;
import com.application.moviecatalog.ui.detail.adapter.CreatedByAdapter;
import com.application.moviecatalog.ui.detail.adapter.GenresAdapter;
import com.application.moviecatalog.ui.detail.adapter.NetworksAdapter;
import com.application.moviecatalog.ui.detail.adapter.ProductionCompaniesAdapter;
import com.application.moviecatalog.ui.detail.adapter.ProductionCountriesAdapter;
import com.application.moviecatalog.ui.detail.adapter.SeasonsAdapter;
import com.application.moviecatalog.ui.detail.adapter.SpokenLanguagesAdapter;
import com.application.moviecatalog.utils.ViewModelFactory;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.text.DecimalFormat;
import java.util.List;

public class DetailListActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    public static final String EXTRA_TV_SHOW = "extra_tv_show";

    private ActivityDetailListBinding activityBinding;
    private ItemsDetailMovieOrTvShowBinding movieOrTvShowBinding;
    private ItemsBelongToCollectionBinding collectionBinding;
    private ItemsLastEpisodeToAirBinding airBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityBinding = ActivityDetailListBinding.inflate(getLayoutInflater());
        movieOrTvShowBinding = activityBinding.itemsDetailMovieOrTvShow;
        collectionBinding = activityBinding.itemsDetailMovieOrTvShow.detailBelongToCollection;
        airBinding = activityBinding.itemsDetailMovieOrTvShow.detailLastEpisodeToAir;
        setContentView(activityBinding.getRoot());

        MovieEntity movieEntity = getIntent().getParcelableExtra(EXTRA_MOVIE);
        TvShowEntity tvShowEntity = getIntent().getParcelableExtra(EXTRA_TV_SHOW);

        setSupportActionBar(activityBinding.toolbar);
        if (getSupportActionBar() != null) {
            if (movieEntity !=null){
                getSupportActionBar().setTitle(movieEntity.getTitle());
            }else {
                getSupportActionBar().setTitle(tvShowEntity.getName());
            }
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        ViewModelFactory factory = ViewModelFactory.getInstance(MovieCatalogRepository.getInstance(RemoteDataSource.getInstance()),this );
        DetailListViewModel viewModel = new ViewModelProvider(this, factory).get(DetailListViewModel.class);
        DecimalFormat formatData = new DecimalFormat("#.#");
        if (movieEntity !=null){
            viewModel.setMoveId(movieEntity.getId());
            activityBinding.progressBar.setVisibility(View.VISIBLE);
            viewModel.getDetailMovie().observe(this, detailMovieEntity -> populateMovie(detailMovieEntity, formatData));
            viewModel.getBelongsToCollectionMovie().observe(this, this::populateBelongToCollectionMovie);

            viewModel.getGenreMovie().observe(this, this::populateGenres);
            viewModel.getProductionCompaniesMovie().observe(this, this::populateProductionCompanies);
            viewModel.getProductionCountriesMovie().observe(this, this::populateProductionCountries);
            viewModel.getSpokenLanguagesMovie().observe(this, this::populateSpokenLanguages);
        } else {
            viewModel.setTvId(tvShowEntity.getId());
            activityBinding.progressBar.setVisibility(View.VISIBLE);
            viewModel.getDetailTvShow().observe(this, detailTvShowEntity -> populateTvShow(detailTvShowEntity, formatData));
            viewModel.getLastEpisodeToAirEntity().observe(this, lastEpisodeToAirEntity -> populateLastEpisodeToAir(lastEpisodeToAirEntity, formatData));
            viewModel.getCreatedByTvShow().observe(this, this::populateCreatedBy);
            viewModel.getNetworksTvShow().observe(this, this::populateNetworks);
            viewModel.getSeasonsTvShow().observe(this, this::populateSeasons);

            viewModel.getGenreTvSow().observe(this, this::populateGenres);
            viewModel.getProductionCompaniesTvShow().observe(this, this::populateProductionCompanies);
            viewModel.getProductionCountriesTvShow().observe(this, this::populateProductionCountries);
            viewModel.getSpokenLanguagesTvShow().observe(this, this::populateSpokenLanguages);
        }
    }

    @SuppressLint("DefaultLocale")
    private void populateMovie(DetailMovieEntity movie, DecimalFormat formatData) {
        activityBinding.progressBar.setVisibility(View.GONE);
        double rating = movie.getVoteAverage() / 2;
        Glide.with(this).load(getString(R.string.poster_path) + movie.getPosterPath()).
                apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_loading)).error(R.drawable.ic_baseline_error).
                into(movieOrTvShowBinding.imgDetailPosterPath);
        if (movie.getTitle() != null){
            movieOrTvShowBinding.tvDetailTitleOrName.setText(movie.getTitle());
            movieOrTvShowBinding.tvDetailReleaseOrFirstDate.setText(getString(R.string.release_date,movie.getReleaseDate()));
        }
        movieOrTvShowBinding.detailRatingBar.setVisibility(View.VISIBLE);
        movieOrTvShowBinding.detailRatingBar.setRating((float) rating);
        movieOrTvShowBinding.tvDetailVoteAverage.setText(formatData.format(rating));
        movieOrTvShowBinding.tvDetailOriginalLanguage.setText(getString(R.string.original_language,movie.getOriginalLanguage()));
        movieOrTvShowBinding.tvDetailRuntime.setText(String.valueOf(getString(R.string.runtime,movie.getRuntime())));
        movieOrTvShowBinding.tvDetailStatus.setText(getString(R.string.status,movie.getStatus()));
        movieOrTvShowBinding.tvDetailOverview.setText(getString(R.string.overview,movie.getOverview()));

        movieOrTvShowBinding.imgDetailBtnLink.setImageResource(R.drawable.ic_baseline_open_in_new);
        movieOrTvShowBinding.imgDetailBtnLink.setOnClickListener(v -> {
            Toast.makeText(this, getString(R.string.link,movie.getTitle()), Toast.LENGTH_SHORT).show();
            String url = getString(R.string.tv_show_share_link,movie.getId());
            Intent link = new Intent(Intent.ACTION_VIEW);
            link.setData(Uri.parse(url));
            startActivity(link);
        });

    }

    private void populateBelongToCollectionMovie(BelongsToCollectionEntity belongsToCollectionEntity) {
        if (belongsToCollectionEntity !=null){
            movieOrTvShowBinding.tvDetailBelongToCollection.setText(R.string.belong_to_collection);
            movieOrTvShowBinding.tvDetailLastEpisodeToAir.setVisibility(View.GONE);
            movieOrTvShowBinding.detailBelongToCollection.getRoot().setVisibility(View.VISIBLE);
            Glide.with(this).load(getString(R.string.poster_path) + belongsToCollectionEntity.getPosterPath()).
                    apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_loading)).error(R.drawable.ic_baseline_error).
                    into(collectionBinding.imgCollectionPosterPath);
            collectionBinding.tvCollectionName.setText(belongsToCollectionEntity.getName());
        } else {
            movieOrTvShowBinding.tvDetailBelongToCollection.setVisibility(View.GONE);
            movieOrTvShowBinding.tvDetailLastEpisodeToAir.setVisibility(View.GONE);
        }
    }

    @SuppressLint("DefaultLocale")
    private void populateTvShow(DetailTvShowEntity tvShow, DecimalFormat formatData) {
        activityBinding.progressBar.setVisibility(View.GONE);
        double rating = tvShow.getVoteAverage() / 2;
        Glide.with(this).load(getString(R.string.poster_path) + tvShow.getPosterPath()).
                apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_loading)).error(R.drawable.ic_baseline_error).
                into(movieOrTvShowBinding.imgDetailPosterPath);
        if (tvShow.getName() != null){
            movieOrTvShowBinding.tvDetailTitleOrName.setText(tvShow.getName());
            movieOrTvShowBinding.tvDetailReleaseOrFirstDate.setText(getString(R.string.first_air_date,tvShow.getFirstAirDate()));
        }
        movieOrTvShowBinding.detailRatingBar.setVisibility(View.VISIBLE);
        movieOrTvShowBinding.detailRatingBar.setRating((float) rating);
        movieOrTvShowBinding.tvDetailVoteAverage.setText(formatData.format(rating));
        movieOrTvShowBinding.tvDetailOriginalLanguage.setText(getString(R.string.original_language,tvShow.getOriginalLanguage()));
        movieOrTvShowBinding.tvDetailRuntime.setText(String.valueOf(tvShow.getEpisodeRunTime()));
        movieOrTvShowBinding.tvDetailStatus.setText(getString(R.string.status,tvShow.getStatus()));
        movieOrTvShowBinding.tvDetailOverview.setText(getString(R.string.overview,tvShow.getOverview()));

        movieOrTvShowBinding.imgDetailBtnLink.setImageResource(R.drawable.ic_baseline_open_in_new);
        movieOrTvShowBinding.imgDetailBtnLink.setOnClickListener(v -> {
            Toast.makeText(this, getString(R.string.link,tvShow.getName()), Toast.LENGTH_SHORT).show();
            String url = getString(R.string.tv_show_share_link,tvShow.getId());
            Intent link = new Intent(Intent.ACTION_VIEW);
            link.setData(Uri.parse(url));
            startActivity(link);
        });
    }

    private void populateLastEpisodeToAir(LastEpisodeToAirEntity lastEpisodeToAirEntity, DecimalFormat formatData) {
        if (lastEpisodeToAirEntity !=null){
            movieOrTvShowBinding.tvDetailBelongToCollection.setVisibility(View.GONE);
            movieOrTvShowBinding.tvDetailLastEpisodeToAir.setText(R.string.last_episode_to_air);
            movieOrTvShowBinding.detailLastEpisodeToAir.getRoot().setVisibility(View.VISIBLE);
            double ratingAir = lastEpisodeToAirEntity.getVoteAverage() / 2;
            airBinding.tvAirAirDate.setText(getString(R.string.air_date,lastEpisodeToAirEntity.getAirDate()));
            airBinding.tvAirEpisodeNumber.setText(String.valueOf(getString(R.string.episode_number,lastEpisodeToAirEntity.getEpisodeNumber())));
            Glide.with(this).load(getString(R.string.poster_path) + lastEpisodeToAirEntity.getStillPath()).
                    apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_loading)).error(R.drawable.ic_baseline_error).
                    into(airBinding.imgAirStillPath);
            airBinding.tvAirName.setText(lastEpisodeToAirEntity.getName());
            airBinding.tvAirOverview.setText(getString(R.string.overview,lastEpisodeToAirEntity.getOverview()));
            airBinding.tvAirSeasonNumber.setText(String.valueOf(getString(R.string.season_number,lastEpisodeToAirEntity.getSeasonNumber())));
            airBinding.airRatingBar.setVisibility(View.VISIBLE);
            airBinding.airRatingBar.setRating((float) ratingAir);
            airBinding.tvAirVoteAverage.setText(formatData.format(ratingAir));
        } else {
            movieOrTvShowBinding.tvDetailBelongToCollection.setVisibility(View.GONE);
            movieOrTvShowBinding.tvDetailLastEpisodeToAir.setVisibility(View.GONE);
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private void populateCreatedBy(List<CreatedByEntity> createdByEntities) {
        if (createdByEntities !=null){
            CreatedByAdapter adapter = new CreatedByAdapter();

            adapter.setCreatedByEntity(createdByEntities);
            adapter.notifyDataSetChanged();

            movieOrTvShowBinding.tvDetailCreatedBy.setText(R.string.created_by);
            movieOrTvShowBinding.rvDetailCreatedBy.setVisibility(View.VISIBLE);
            movieOrTvShowBinding.rvDetailCreatedBy.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
            movieOrTvShowBinding.rvDetailCreatedBy.setHasFixedSize(true);
            movieOrTvShowBinding.rvDetailCreatedBy.setAdapter(adapter);
        }else {
            movieOrTvShowBinding.tvDetailCreatedBy.setVisibility(View.GONE);
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    private void populateNetworks(List<NetworksEntity> networksEntities) {
        if (networksEntities !=null){
            NetworksAdapter adapter = new NetworksAdapter();

            adapter.setNetworksEntity(networksEntities);
            adapter.notifyDataSetChanged();

            movieOrTvShowBinding.tvDetailNetworks.setText(R.string.network);
            movieOrTvShowBinding.rvDetailNetworks.setVisibility(View.VISIBLE);
            movieOrTvShowBinding.rvDetailNetworks.setLayoutManager(new LinearLayoutManager(this));
            movieOrTvShowBinding.rvDetailNetworks.setHasFixedSize(true);
            movieOrTvShowBinding.rvDetailNetworks.setAdapter(adapter);
        } else {
            movieOrTvShowBinding.tvDetailNetworks.setVisibility(View.GONE);
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private void populateSeasons(List<SeasonsEntity> seasonsEntities) {
        if (seasonsEntities !=null){
            SeasonsAdapter adapter = new SeasonsAdapter();

            adapter.setSeasonsEntity(seasonsEntities);
            adapter.notifyDataSetChanged();

            movieOrTvShowBinding.tvDetailSeasons.setText(R.string.seasons);
            movieOrTvShowBinding.rvDetailSeasons.setVisibility(View.VISIBLE);
            movieOrTvShowBinding.rvDetailSeasons.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
            movieOrTvShowBinding.rvDetailSeasons.setHasFixedSize(true);
            movieOrTvShowBinding.rvDetailSeasons.setAdapter(adapter);
        } else {
            movieOrTvShowBinding.tvDetailSeasons.setVisibility(View.GONE);
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private void populateGenres(List<GenresEntity> genresEntities) {
        if (genresEntities !=null) {
            GenresAdapter adapter = new GenresAdapter();

            adapter.setGenresEntityList(genresEntities);
            adapter.notifyDataSetChanged();

            movieOrTvShowBinding.tvDetailGenres.setText(R.string.genre);
            movieOrTvShowBinding.rvDetailGenres.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
            movieOrTvShowBinding.rvDetailGenres.setHasFixedSize(true);
            movieOrTvShowBinding.rvDetailGenres.setAdapter(adapter);
        } else {
            movieOrTvShowBinding.tvDetailGenres.setVisibility(View.INVISIBLE);
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private void populateProductionCompanies(List<ProductionCompaniesEntity> productionCompaniesEntities) {
        if (productionCompaniesEntities !=null){
            ProductionCompaniesAdapter adapter = new ProductionCompaniesAdapter();

            adapter.setProductionCompaniesEntity(productionCompaniesEntities);
            adapter.notifyDataSetChanged();

            movieOrTvShowBinding.tvDetailProductionCompanies.setText(R.string.production_companies);
            movieOrTvShowBinding.rvDetailProductionCompanies.setVisibility(View.VISIBLE);
            movieOrTvShowBinding.rvDetailProductionCompanies.setLayoutManager(new LinearLayoutManager(this));
            movieOrTvShowBinding.rvDetailProductionCompanies.setHasFixedSize(true);
            movieOrTvShowBinding.rvDetailProductionCompanies.setAdapter(adapter);
        } else {
            movieOrTvShowBinding.tvDetailProductionCompanies.setVisibility(View.GONE);
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private void populateProductionCountries(List<ProductionCountriesEntity> productionCountriesEntities) {
        if (productionCountriesEntities !=null){
            ProductionCountriesAdapter adapter = new ProductionCountriesAdapter();

            adapter.setProductionCountriesEntity(productionCountriesEntities);
            adapter.notifyDataSetChanged();

            movieOrTvShowBinding.tvDetailProductionCountries.setText(R.string.production_companies);
            movieOrTvShowBinding.rvDetailProductionCountries.setVisibility(View.VISIBLE);
            movieOrTvShowBinding.rvDetailProductionCountries.setLayoutManager(new LinearLayoutManager(this));
            movieOrTvShowBinding.rvDetailProductionCountries.setHasFixedSize(true);
            movieOrTvShowBinding.rvDetailProductionCountries.setAdapter(adapter);
        } else {
            movieOrTvShowBinding.tvDetailProductionCountries.setVisibility(View.GONE);
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private void populateSpokenLanguages(List<SpokenLanguagesEntity> spokenLanguagesEntities) {
        if (spokenLanguagesEntities !=null){
            SpokenLanguagesAdapter adapter = new SpokenLanguagesAdapter();

            adapter.setSpokenLanguagesEntity(spokenLanguagesEntities);
            adapter.notifyDataSetChanged();

            movieOrTvShowBinding.tvDetailSpokenLanguages.setText(R.string.spoken_languages);
            movieOrTvShowBinding.rvDetailSpokenLanguages.setVisibility(View.VISIBLE);
            movieOrTvShowBinding.rvDetailSpokenLanguages.setLayoutManager(new LinearLayoutManager(this));
            movieOrTvShowBinding.rvDetailSpokenLanguages.setHasFixedSize(true);
            movieOrTvShowBinding.rvDetailSpokenLanguages.setAdapter(adapter);
        } else {
            movieOrTvShowBinding.tvDetailSpokenLanguages.setVisibility(View.GONE);
        }
    }
}