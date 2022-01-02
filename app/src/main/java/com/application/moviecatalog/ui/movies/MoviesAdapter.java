package com.application.moviecatalog.ui.movies;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.moviecatalog.R;
import com.application.moviecatalog.data.MovieEntity;
import com.application.moviecatalog.databinding.ItemsListMovieOrTvShowBinding;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieCatalogViewHolder> {

    private final MoviesCallback moviesCallback;

    public MoviesAdapter(MoviesCallback moviesCallback){
        this.moviesCallback = moviesCallback;
    }

    private final List<MovieEntity> movieEntities = new ArrayList<>();

    public void setMoviesCatalogEntityList (List<MovieEntity> movieEntities){
        if (movieEntities == null) return;
        this.movieEntities.clear();
        this.movieEntities.addAll(movieEntities);
    }

    @NonNull
    @Override
    public MoviesAdapter.MovieCatalogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemsListMovieOrTvShowBinding binding = ItemsListMovieOrTvShowBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
        return new MovieCatalogViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.MovieCatalogViewHolder holder, int position) {
        MovieEntity movieEntity = movieEntities.get(position);
        holder.bind(movieEntity);
    }

    @Override
    public int getItemCount() {
        return movieEntities.size();
    }

    public class MovieCatalogViewHolder extends RecyclerView.ViewHolder {
        ItemsListMovieOrTvShowBinding binding;

        public MovieCatalogViewHolder(ItemsListMovieOrTvShowBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        public void bind(MovieEntity movieEntity) {
            DecimalFormat formatData = new DecimalFormat("#.#");
            double rating = movieEntity.getVoteAverage() / 2;
            Glide.with(itemView.getContext()).load(itemView.getContext().getString(R.string.poster_path) + movieEntity.getPosterPath()).
                    apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_loading)).error(R.drawable.ic_baseline_error).
                    into(binding.imgPosterPath);
            binding.tvTitleOrName.setText(movieEntity.getTitle());
            binding.tvReleaseOrFirstDate.setText(itemView.getResources().getString(R.string.release_date,movieEntity.getReleaseDate()));
            binding.ratingBar.setRating((float) rating);
            binding.tvVoteAverage.setText(formatData.format(rating));
            binding.tvOriginalLanguage.setText(itemView.getResources().getString(R.string.original_language,movieEntity.getOriginalLanguage()));
            binding.tvOverview.setText(movieEntity.getOverview());

            itemView.setOnClickListener(v -> moviesCallback.onItemClick(movieEntity));
            binding.imgBtnShare.setOnClickListener(v -> moviesCallback.onShareClick(movieEntity));
        }
    }
}
