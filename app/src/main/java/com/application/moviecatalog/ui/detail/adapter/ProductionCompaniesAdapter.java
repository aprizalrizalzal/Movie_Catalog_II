package com.application.moviecatalog.ui.detail.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.moviecatalog.R;
import com.application.moviecatalog.data.source.local.entity.ProductionCompaniesEntity;
import com.application.moviecatalog.databinding.ItemsListProductionCompanyOrNetworksBinding;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class ProductionCompaniesAdapter extends RecyclerView.Adapter<ProductionCompaniesAdapter.ProductionCompaniesViewHolder> {
    private final List<ProductionCompaniesEntity> productionCompaniesEntities = new ArrayList<>();

    public void setProductionCompaniesEntity(List<ProductionCompaniesEntity> productionCompaniesEntities){
        if (productionCompaniesEntities == null) return;
        this.productionCompaniesEntities.clear();
        this.productionCompaniesEntities.addAll(productionCompaniesEntities);
    }

    @NonNull
    @Override
    public ProductionCompaniesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemsListProductionCompanyOrNetworksBinding binding = ItemsListProductionCompanyOrNetworksBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ProductionCompaniesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductionCompaniesViewHolder holder, int position) {
        ProductionCompaniesEntity productionCompaniesEntity = productionCompaniesEntities.get(position);
        holder.bind(productionCompaniesEntity);
    }

    @Override
    public int getItemCount() {
        return productionCompaniesEntities.size();
    }

    public static class ProductionCompaniesViewHolder extends RecyclerView.ViewHolder {
        private final ItemsListProductionCompanyOrNetworksBinding binding;
        public ProductionCompaniesViewHolder(ItemsListProductionCompanyOrNetworksBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        public void bind(ProductionCompaniesEntity productionCompaniesEntity) {
            Glide.with(itemView.getContext()).load(itemView.getContext().getString(R.string.poster_path) + productionCompaniesEntity.getLogoPath()).
                    apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_loading)).error(R.drawable.ic_baseline_error).
                    into(binding.imgCompanyOrNetworkLogoPath);
            binding.tvCompanyOrNetworkName.setText(productionCompaniesEntity.getName());
            binding.tvCompanyOrNetworkOriginCountry.setText(productionCompaniesEntity.getOriginCountry());
        }
    }
}
