package com.example.onlineproducts;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineproducts.databinding.CategoryItemBinding;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

    private List<String> items;
    private ItemOnClickListener itemOnClickListener;

    public CategoriesAdapter(List<String> items) {
        this.items = items;
    }

    void createCategory(List<String> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    void setItemOnClickListener(ItemOnClickListener itemOnClickListener) {
        this.itemOnClickListener = itemOnClickListener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CategoryItemBinding binding = CategoryItemBinding.inflate(inflater, parent, false);
        CategoryViewHolder viewHolder = new CategoryViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        String category = items.get(position);
        holder.binding.categoryTxt.setText(category);
        holder.binding.getRoot().setOnClickListener(v -> {
            itemOnClickListener.categoryOnClick(category);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
