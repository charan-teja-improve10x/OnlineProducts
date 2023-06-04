package com.example.onlineproducts.products;

import android.view.LayoutInflater;
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
//        holder.binding.titleTxt.setText(product.getTitle());
//        holder.binding.priceTxt.setText(String.valueOf(product.getPrice()));
//        holder.binding.ratingRb.setRating(product.getRating().getRate());
//        holder.binding.rateTxt.setText(String.valueOf(product.getRating().getRate()));
//        holder.binding.countTxt.setText(String.valueOf(product.getRating().getCount()));
//        Picasso.get().load(product.getImageUrl()).into(holder.binding.imageIv);
//        holder.binding.getRoot().setOnClickListener(v -> {
//            onProductActionListener.onProductClick(product.getId());
//        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
