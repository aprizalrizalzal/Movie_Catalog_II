package com.application.moviecatalog.ui.detail.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.moviecatalog.data.source.local.entity.GenresEntity;
import com.application.moviecatalog.databinding.ItemsListGenreBinding;

import java.util.ArrayList;
import java.util.List;

public class GenresAdapter extends RecyclerView.Adapter<GenresAdapter.GenresViewHolder> {
    private final List<GenresEntity> genresEntities = new ArrayList<>();

    public void setGenresEntityList (List<GenresEntity> genresEntities) {
        if (genresEntities == null) return;
        this.genresEntities.clear();
        this.genresEntities.addAll(genresEntities);
    }

    @NonNull
    @Override
    public GenresViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemsListGenreBinding binding = ItemsListGenreBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new GenresViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GenresViewHolder holder, int position) {
        GenresEntity genresEntity = genresEntities.get(position);
        holder.bind(genresEntity);

    }

    @Override
    public int getItemCount() {
        return genresEntities.size();
    }

    public static class GenresViewHolder extends RecyclerView.ViewHolder {
        private final ItemsListGenreBinding binding;
        public GenresViewHolder(ItemsListGenreBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        public void bind(GenresEntity genresEntity) {
            binding.tvGenres.setText(genresEntity.getName());
        }
    }
}
