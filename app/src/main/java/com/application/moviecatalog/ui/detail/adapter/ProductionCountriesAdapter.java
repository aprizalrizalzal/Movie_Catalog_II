package com.application.moviecatalog.ui.detail.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.moviecatalog.data.source.local.entity.ProductionCountriesEntity;
import com.application.moviecatalog.databinding.ItemsListProductionCountriesBinding;

import java.util.ArrayList;
import java.util.List;

public class ProductionCountriesAdapter extends RecyclerView.Adapter<ProductionCountriesAdapter.ProductionCountriesViewHolder> {
    private final List<ProductionCountriesEntity> productionCountriesEntities = new ArrayList<>();

    public void setProductionCountriesEntity(List<ProductionCountriesEntity> productionCountriesEntities){
        if (productionCountriesEntities == null) return;
        this.productionCountriesEntities.clear();
        this.productionCountriesEntities.addAll(productionCountriesEntities);
    }

    @NonNull
    @Override
    public ProductionCountriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemsListProductionCountriesBinding binding = ItemsListProductionCountriesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ProductionCountriesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductionCountriesViewHolder holder, int position) {
        ProductionCountriesEntity productionCountriesEntity = productionCountriesEntities.get(position);
        holder.bind(productionCountriesEntity);
    }

    @Override
    public int getItemCount() {
        return productionCountriesEntities.size();
    }

    public static class ProductionCountriesViewHolder extends RecyclerView.ViewHolder {
        private final ItemsListProductionCountriesBinding binding;
        public ProductionCountriesViewHolder(ItemsListProductionCountriesBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        public void bind(ProductionCountriesEntity productionCountriesEntity) {
            binding.tvProductionCountries.setText(productionCountriesEntity.getName());
        }
    }
}
