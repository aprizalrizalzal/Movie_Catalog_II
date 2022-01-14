package com.application.moviecatalog.ui.detail.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.moviecatalog.R;
import com.application.moviecatalog.data.source.local.entity.tvShow.detail.NetworksEntity;
import com.application.moviecatalog.databinding.ItemsListProductionCompanyOrNetworksBinding;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class NetworksAdapter extends RecyclerView.Adapter<NetworksAdapter.NetworksViewHolder> {
    private final List<NetworksEntity> networksEntities = new ArrayList<>();

    public void setNetworksEntity(List<NetworksEntity> networksEntities){
        if (networksEntities == null) return;
        this.networksEntities.clear();
        this.networksEntities.addAll(networksEntities);
    }

    @NonNull
    @Override
    public NetworksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemsListProductionCompanyOrNetworksBinding binding = ItemsListProductionCompanyOrNetworksBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new NetworksViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NetworksViewHolder holder, int position) {
        NetworksEntity networksEntity = networksEntities.get(position);
        holder.bind(networksEntity);
    }

    @Override
    public int getItemCount() {
        return networksEntities.size();
    }

    public static class NetworksViewHolder extends RecyclerView.ViewHolder {
        private final ItemsListProductionCompanyOrNetworksBinding binding;
        public NetworksViewHolder(ItemsListProductionCompanyOrNetworksBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        public void bind(NetworksEntity networksEntity) {
            Glide.with(itemView.getContext()).load(itemView.getContext().getString(R.string.poster_path) + networksEntity.getLogoPath()).
                    apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_loading)).error(R.drawable.ic_baseline_error).
                    into(binding.imgCompanyOrNetworkLogoPath);
            binding.tvCompanyOrNetworkName.setText(networksEntity.getName());
            binding.tvCompanyOrNetworkOriginCountry.setText(networksEntity.getOriginCountry());
        }
    }
}
