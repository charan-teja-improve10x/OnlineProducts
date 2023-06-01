package com.example.onlineproducts.products;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.onlineproducts.databinding.ActivityProductsBinding;
import com.example.onlineproducts.models.Product;
import com.example.onlineproducts.network.FakeApi;
import com.example.onlineproducts.network.FakeApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends AppCompatActivity {

    private ActivityProductsBinding binding;
    private ProductsAdapter adapter;
    private List<Product> products = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        String category = intent.getStringExtra("category");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Products");
        actionBar.setDisplayHomeAsUpEnabled(true);
        fetchProducts(category);
        createAdapter();
        connectAdapter();
    }

    private void createAdapter() {
        adapter = new ProductsAdapter(products);
    }

    private void connectAdapter(){
        binding.productsRv.setLayoutManager(new GridLayoutManager(this,2));
        binding.productsRv.setAdapter(adapter);
    }

    private void fetchProducts(String category) {
        FakeApiService fakeApiService = new FakeApi().createFakeApi();
        Call<List<Product>> call = fakeApiService.fetchProducts(category);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                Toast.makeText(ProductsActivity.this, "Fetch Success", Toast.LENGTH_LONG).show();
                adapter.createProducts(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(ProductsActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}