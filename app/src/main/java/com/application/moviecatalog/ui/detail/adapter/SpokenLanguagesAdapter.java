package com.application.moviecatalog.ui.detail.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.moviecatalog.data.source.local.entity.SpokenLanguagesEntity;
import com.application.moviecatalog.databinding.ItemsListSpokenLanguagesBinding;

import java.util.ArrayList;
import java.util.List;

public class SpokenLanguagesAdapter extends RecyclerView.Adapter<SpokenLanguagesAdapter.SpokenLanguagesViewHolder> {
    private final List<SpokenLanguagesEntity> spokenLanguagesEntities = new ArrayList<>();

    public void setSpokenLanguagesEntity(List<SpokenLanguagesEntity> spokenLanguagesEntities){
        if (spokenLanguagesEntities == null) return;
        this.spokenLanguagesEntities.clear();
        this.spokenLanguagesEntities.addAll(spokenLanguagesEntities);
    }

    @NonNull
    @Override
    public SpokenLanguagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemsListSpokenLanguagesBinding binding = ItemsListSpokenLanguagesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new SpokenLanguagesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SpokenLanguagesViewHolder holder, int position) {
        SpokenLanguagesEntity spokenLanguagesEntity = spokenLanguagesEntities.get(position);
        holder.bind(spokenLanguagesEntity);
    }

    @Override
    public int getItemCount() {
        return spokenLanguagesEntities.size();
    }

    public static class SpokenLanguagesViewHolder extends RecyclerView.ViewHolder {
        private final ItemsListSpokenLanguagesBinding binding;
        public SpokenLanguagesViewHolder(ItemsListSpokenLanguagesBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        public void bind(SpokenLanguagesEntity spokenLanguagesEntity) {
            binding.tvEnglishName.setText(spokenLanguagesEntity.getEnglishName());
            binding.tvName.setText(spokenLanguagesEntity.getName());
        }
    }
}
