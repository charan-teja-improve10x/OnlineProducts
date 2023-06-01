package com.example.onlineproducts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.onlineproducts.databinding.ActivityCategoriesBinding;
import com.example.onlineproducts.models.Product;
import com.example.onlineproducts.network.FakeApi;
import com.example.onlineproducts.network.FakeApiService;
import com.example.onlineproducts.products.ProductsActivity;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesActivity extends AppCompatActivity implements ItemOnClickListener {

    private ActivityCategoriesBinding binding;
    private CategoryAdapter categoryAdapter;
    private List<String> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getCategories();
        setAdapter();
        connectAdapter();
    }

    private void setAdapter() {
        categoryAdapter = new CategoryAdapter(items);
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
                Toast.makeText(CategoriesActivity.this, "Fetch Success", Toast.LENGTH_LONG).show();
                categoryAdapter.createCategory(response.body());
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {

            }
        });
    }

    @Override
    public void categoryOnClick() {
        Intent intent = new Intent(this,ProductsActivity.class);
        Toast.makeText(this, "CategoryItem is clicked", Toast.LENGTH_SHORT).show();
        intent.putExtra("items", (Serializable) items);
        startActivity(intent);
    }
}