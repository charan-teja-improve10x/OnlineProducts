package com.example.onlineproducts.category;

import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.onlineproducts.BaseActivity;
import com.example.onlineproducts.SearchItemActivity;
import com.example.onlineproducts.databinding.ActivityCategoriesBinding;
import com.example.onlineproducts.models.Product;
import com.example.onlineproducts.products.ProductsActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesActivity extends SearchItemActivity implements ItemOnClickListener {

    private ActivityCategoriesBinding binding;
    private CategoriesAdapter categoryAdapter;
    private List<Product> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Categories");
        getCategories();
        setupAdapter();
        connectAdapter();
    }

    private void setupAdapter() {
        categoryAdapter = new CategoriesAdapter(items);
        categoryAdapter.setItemOnClickListener(this);
    }

    private void connectAdapter() {
        binding.categoryRv.setLayoutManager(new LinearLayoutManager(this));
        binding.categoryRv.setAdapter(categoryAdapter);
    }

    private void getCategories() {
        Call<List<Product>> call = fakeApiService.fetchCategories();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                setProgressBarVisible();
                categoryAdapter.createCategory(response.body());
                setProgressBarGone();
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(CategoriesActivity.this, "Fetch Categories failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void categoryOnClick(Product product) {
        Intent intent = new Intent(this, ProductsActivity.class);
        intent.putExtra("product", product);
        startActivity(intent);
    }

    private void setProgressBarVisible() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    private void setProgressBarGone() {
        binding.progressBar.setVisibility(View.GONE);
    }
}