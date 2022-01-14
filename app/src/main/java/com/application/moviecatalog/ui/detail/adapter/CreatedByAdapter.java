package com.application.moviecatalog.ui.detail.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.moviecatalog.R;
import com.application.moviecatalog.data.source.local.entity.tvShow.detail.CreatedByEntity;
import com.application.moviecatalog.databinding.ItemsListCreatedByBinding;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class CreatedByAdapter extends RecyclerView.Adapter<CreatedByAdapter.CreatedByViewHolder> {
    private final List<CreatedByEntity> createdByEntities = new ArrayList<>();

    public void setCreatedByEntity(List<CreatedByEntity> createdByEntities){
        if (createdByEntities == null) return;
        this.createdByEntities.clear();
        this.createdByEntities.addAll(createdByEntities);
    }

    @NonNull
    @Override
    public CreatedByViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemsListCreatedByBinding binding = ItemsListCreatedByBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CreatedByViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CreatedByViewHolder holder, int position) {
        CreatedByEntity CreatedByEntity = createdByEntities.get(position);
        holder.bind(CreatedByEntity);
    }

    @Override
    public int getItemCount() {
        return createdByEntities.size();
    }

    public static class CreatedByViewHolder extends RecyclerView.ViewHolder {
        private final ItemsListCreatedByBinding binding;
        public CreatedByViewHolder(ItemsListCreatedByBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        public void bind(CreatedByEntity createdByEntity) {
            int male = 2;
            int female = 1;
            if (createdByEntity.getGender() == male) {
                binding.tvByGender.setText(itemView.getResources().getString(R.string.gender,itemView.getResources().getString(R.string.male)));
            }else if (createdByEntity.getGender() == female){
                binding.tvByGender.setText(String.valueOf(itemView.getResources().getString(R.string.gender,itemView.getResources().getString(R.string.female))));
            }
            binding.tvByName.setText(createdByEntity.getName());
            binding.tvByOriginalLanguage.setText(itemView.getContext().getString(R.string.original_language,createdByEntity.getOriginalLanguage()));
            Glide.with(itemView.getContext()).load(itemView.getContext().getString(R.string.poster_path) + createdByEntity.getProfilePath()).
                    apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_loading)).error(R.drawable.ic_baseline_error).
                    into(binding.imgByProfilePath);
        }
    }
}
