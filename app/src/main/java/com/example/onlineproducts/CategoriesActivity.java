package com.example.onlineproducts;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.onlineproducts.databinding.ActivityCategoriesBinding;
import com.example.onlineproducts.network.FakeApi;
import com.example.onlineproducts.network.FakeApiService;
import com.example.onlineproducts.products.ProductsActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesActivity extends AppCompatActivity implements ItemOnClickListener {

    private ActivityCategoriesBinding binding;
    private CategoriesAdapter categoryAdapter;
    private List<String> items = new ArrayList<>();

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
        FakeApiService fakeApiService = new FakeApi().createFakeApi();
        Call<List<String>> call = fakeApiService.fetchCategories();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                categoryAdapter.createCategory(response.body());
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Toast.makeText(CategoriesActivity.this, "Fetch Categories failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void categoryOnClick(String category) {
        Intent intent = new Intent(this, ProductsActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }
}