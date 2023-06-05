package com.example.onlineproducts.carts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineproducts.databinding.CartItemBinding;

import java.util.List;

public class CartProductsAdapter extends RecyclerView.Adapter<CartProductViewHolder> {

    private List<CartProduct> cartProducts;

    public CartProductsAdapter(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }

    void setCartProducts(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CartProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CartItemBinding binding = CartItemBinding.inflate(inflater, parent, false);
        CartProductViewHolder viewHolder = new CartProductViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartProductViewHolder holder, int position) {
        CartProduct cartProduct = cartProducts.get(position);
        holder.binding.productId.setText(String.valueOf(cartProduct.getProductId()));
        if (cartProduct.getQuantity() == 0) {
            holder.binding.removeIb.setVisibility(View.GONE);
            holder.binding.quantityTxt.setVisibility(View.GONE);
        } else {
            holder.binding.quantityTxt.setText(String.valueOf(cartProduct.getQuantity()));
            holder.binding.removeIb.setVisibility(View.VISIBLE);
            holder.binding.quantityTxt.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return cartProducts.size();
    }
}
