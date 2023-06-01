package com.example.onlineproducts.products;

import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineproducts.databinding.ProductItemBinding;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    public ProductItemBinding binding;

    public ProductViewHolder(ProductItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
