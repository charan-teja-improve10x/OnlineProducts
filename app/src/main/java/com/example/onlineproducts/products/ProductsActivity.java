package com.example.onlineproducts.products;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.onlineproducts.databinding.ActivityProductsBinding;

public class ProductsActivity extends AppCompatActivity {

    private ActivityProductsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Products");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}