package com.example.onlineproducts.carts;

import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineproducts.databinding.CartItemBinding;

public class CartProductViewHolder extends RecyclerView.ViewHolder {

    CartItemBinding binding;

    public CartProductViewHolder(CartItemBinding binding){
        super(binding.getRoot());
        this.binding = binding;
    }
}
