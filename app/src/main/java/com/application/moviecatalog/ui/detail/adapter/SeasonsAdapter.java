package com.application.moviecatalog.ui.detail.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.moviecatalog.R;
import com.application.moviecatalog.data.source.local.entity.tvShow.detail.SeasonsEntity;
import com.application.moviecatalog.databinding.ItemsListSeasonsBinding;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class SeasonsAdapter extends RecyclerView.Adapter<SeasonsAdapter.SeasonsViewHolder> {
    private final List<SeasonsEntity> seasonsEntities = new ArrayList<>();

    public void setSeasonsEntity(List<SeasonsEntity> seasonsEntities){
        if (seasonsEntities == null) return;
        this.seasonsEntities.clear();
        this.seasonsEntities.addAll(seasonsEntities);
    }

    @NonNull
    @Override
    public SeasonsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemsListSeasonsBinding binding = ItemsListSeasonsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new SeasonsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SeasonsViewHolder holder, int position) {
        SeasonsEntity seasonsEntity = seasonsEntities.get(position);
        holder.bind(seasonsEntity);
    }

    @Override
    public int getItemCount() {
        return seasonsEntities.size();
    }

    public static class SeasonsViewHolder extends RecyclerView.ViewHolder {
        private final ItemsListSeasonsBinding binding;
        public SeasonsViewHolder(ItemsListSeasonsBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        public void bind(SeasonsEntity seasonsEntity) {
            binding.tvSeasonsAirDate.setText(itemView.getResources().getString(R.string.air_date,seasonsEntity.getName()));
            binding.tvSeasonsEpisodeCount.setText(String.valueOf(itemView.getResources().getString(R.string.episode_count,seasonsEntity.getEpisodeCount())));
            binding.tvSeasonsName.setText(seasonsEntity.getName());
            binding.tvSeasonsOverview.setText(itemView.getResources().getString(R.string.overview,seasonsEntity.getOverview()));
            Glide.with(itemView.getContext()).load(itemView.getContext().getString(R.string.poster_path) + seasonsEntity.getPosterPath()).
                    apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_loading)).error(R.drawable.ic_baseline_error).
                    into(binding.imgSeasonsPosterPath);
            binding.tvSeasonNumber.setText(String.valueOf(itemView.getResources().getString(R.string.season_number,seasonsEntity.getSeasonNumber())));
        }
    }
}
