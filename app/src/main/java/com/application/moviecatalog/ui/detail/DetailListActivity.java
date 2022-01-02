package com.application.moviecatalog.ui.detail;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.application.moviecatalog.R;
import com.application.moviecatalog.data.MovieEntity;
import com.application.moviecatalog.data.TvShowEntity;
import com.application.moviecatalog.databinding.ActivityDetailListBinding;
import com.application.moviecatalog.databinding.ItemsDetailMovieOrTvShowBinding;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.text.DecimalFormat;

public class DetailListActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    public static final String EXTRA_TV_SHOW = "extra_tv_show";

    private ItemsDetailMovieOrTvShowBinding itemsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.application.moviecatalog.databinding.ActivityDetailListBinding binding = ActivityDetailListBinding.inflate(getLayoutInflater());
        itemsBinding = binding.itemsDetailMovieOrTvShow;
        setContentView(binding.getRoot());

        MovieEntity movieEntity = getIntent().getParcelableExtra(EXTRA_MOVIE);
        TvShowEntity tvShowEntity = getIntent().getParcelableExtra(EXTRA_TV_SHOW);

        setSupportActionBar(binding.toolbar);
        if (getSupportActionBar() != null) {
            if (movieEntity !=null){
                getSupportActionBar().setTitle(movieEntity.getTitle());
            }else {
                getSupportActionBar().setTitle(tvShowEntity.getName());
            }
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        DetailListViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DetailListViewModel.class);
        DecimalFormat formatData = new DecimalFormat("#.#");
        if (movieEntity !=null){
            populateMovie(viewModel.getMovie(movieEntity.getId()), formatData);
        } else {
            populateTvShow(viewModel.getTvShow(tvShowEntity.getId()), formatData);
        }
    }

    @SuppressLint("DefaultLocale")
    private void populateMovie(MovieEntity movie, DecimalFormat formatData) {
        double rating = movie.getVoteAverage() / 2;
        Glide.with(this).load(getString(R.string.poster_path) + movie.getPosterPath()).
                apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_loading)).error(R.drawable.ic_baseline_error).
                into(itemsBinding.imgPosterPath);
        if (movie.getTitle() != null){
            itemsBinding.tvDetailTitleOrName.setText(movie.getTitle());
            itemsBinding.tvDetailReleaseOrFirstDate.setText(getString(R.string.release_date,movie.getReleaseDate()));
        }
        itemsBinding.detailRatingBar.setRating((float) rating);
        itemsBinding.tvDetailVoteAverage.setText(formatData.format(rating));
        itemsBinding.tvOriginalLanguage.setText(getString(R.string.original_language,movie.getOriginalLanguage()));
        itemsBinding.tvDetailOverview.setText(movie.getOverview());

        itemsBinding.imgBtnLink.setOnClickListener(v -> {
            Toast.makeText(this, getString(R.string.link,movie.getTitle()), Toast.LENGTH_SHORT).show();
            String url = getString(R.string.tv_show_share_link,movie.getId());
            Intent link = new Intent(Intent.ACTION_VIEW);
            link.setData(Uri.parse(url));
            startActivity(link);
        });
    }

    @SuppressLint("DefaultLocale")
    private void populateTvShow(TvShowEntity tvShow, DecimalFormat formatData) {
        double rating = tvShow.getVoteAverage() / 2;
        Glide.with(this).load(getString(R.string.poster_path) + tvShow.getPosterPath()).
                apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_loading)).error(R.drawable.ic_baseline_error).
                into(itemsBinding.imgPosterPath);
        if (tvShow.getName() != null){
            itemsBinding.tvDetailTitleOrName.setText(tvShow.getName());
            itemsBinding.tvDetailReleaseOrFirstDate.setText(getString(R.string.first_air_date,tvShow.getFirstAirDate()));
        }
        itemsBinding.detailRatingBar.setRating((float) rating);
        itemsBinding.tvDetailVoteAverage.setText(formatData.format(rating));
        itemsBinding.tvOriginalLanguage.setText(getString(R.string.original_language,tvShow.getOriginalLanguage()));
        itemsBinding.tvDetailOverview.setText(tvShow.getOverview());

        itemsBinding.imgBtnLink.setOnClickListener(v -> {
            Toast.makeText(this, getString(R.string.link,tvShow.getName()), Toast.LENGTH_SHORT).show();
            String url = getString(R.string.tv_show_share_link,tvShow.getId());
            Intent link = new Intent(Intent.ACTION_VIEW);
            link.setData(Uri.parse(url));
            startActivity(link);
        });
    }
}