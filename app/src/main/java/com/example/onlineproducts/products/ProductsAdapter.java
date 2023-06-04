package com.example.onlineproducts.products;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineproducts.databinding.ProductItemBinding;
import com.example.onlineproducts.models.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    private List<Product> products;

    private OnProductActionListener onProductActionListener;

    public ProductsAdapter(List<Product> products) {
        this.products = products;
    }

    void createProducts(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    void setOnProductActionListener(OnProductActionListener onProductActionListener) {
        this.onProductActionListener = onProductActionListener;
    }
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ProductItemBinding binding = ProductItemBinding.inflate(inflater,parent,false);
        ProductViewHolder viewHolder = new ProductViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = products.get(position);
        holder.binding.titleTxt.setText(product.getTitle());
        holder.binding.priceTxt.setText(String.valueOf(product.getPrice()));
        holder.binding.countTxt.setVisibility(View.GONE);
        holder.binding.rateTxt.setVisibility(View.GONE);
        holder.binding.ratingRb.setVisibility(View.GONE);
        Picasso.get().load(product.getImages().get(0)).into(holder.binding.imageIv);
        holder.binding.getRoot().setOnClickListener(v -> {
            onProductActionListener.onProductClick(product.getId());
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
