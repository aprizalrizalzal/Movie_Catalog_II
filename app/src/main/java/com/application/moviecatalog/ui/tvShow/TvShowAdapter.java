package com.application.moviecatalog.ui.tvShow;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.moviecatalog.R;
import com.application.moviecatalog.data.source.local.entity.tvShow.list.TvShowEntity;
import com.application.moviecatalog.databinding.ItemsListMovieOrTvShowBinding;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.TvShowCatalogViewHolder> {

    private final TvShowCallback tvShowCallback;

    public TvShowAdapter(TvShowCallback tvShowCallback){
        this.tvShowCallback = tvShowCallback;

    }

    private final List<TvShowEntity> tvShowEntities = new ArrayList<>();

    public void setTvShowEntityList(List<TvShowEntity> tvShowEntities){
        if (tvShowEntities == null) return;
        this.tvShowEntities.clear();
        this.tvShowEntities.addAll(tvShowEntities);
    }

    @NonNull
    @Override
    public TvShowAdapter.TvShowCatalogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemsListMovieOrTvShowBinding binding = ItemsListMovieOrTvShowBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
        return new TvShowCatalogViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowAdapter.TvShowCatalogViewHolder holder, int position) {
        TvShowEntity tvShowEntity = tvShowEntities.get(position);
        holder.bind(tvShowEntity);
    }

    @Override
    public int getItemCount() {
        return tvShowEntities.size();
    }

    public class TvShowCatalogViewHolder extends RecyclerView.ViewHolder {
        ItemsListMovieOrTvShowBinding binding;

        public TvShowCatalogViewHolder(ItemsListMovieOrTvShowBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        public void bind(TvShowEntity tvShowEntity) {
            DecimalFormat formatData = new DecimalFormat("#.#");
            double rating = tvShowEntity.getVoteAverage() / 2;
            Glide.with(itemView.getContext()).load(itemView.getContext().getString(R.string.poster_path) + tvShowEntity.getPosterPath()).
                    apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_loading)).error(R.drawable.ic_baseline_error).
                    into(binding.imgPosterPath);
            binding.tvTitleOrName.setText(tvShowEntity.getName());
            binding.tvReleaseOrFirstDate.setText(itemView.getResources().getString(R.string.first_air_date,tvShowEntity.getFirstAirDate()));
            binding.ratingBar.setRating((float) rating);
            binding.tvVoteAverage.setText(formatData.format(rating));
            binding.tvOriginalLanguage.setText(itemView.getResources().getString(R.string.original_language,tvShowEntity.getOriginalLanguage()));
            binding.tvOverview.setText(itemView.getResources().getString(R.string.overview,tvShowEntity.getOverview()));

            itemView.setOnClickListener(v -> tvShowCallback.onItemClick(tvShowEntity));
            binding.imgBtnShare.setOnClickListener(v -> tvShowCallback.onShareClick(tvShowEntity));
        }
    }
}
