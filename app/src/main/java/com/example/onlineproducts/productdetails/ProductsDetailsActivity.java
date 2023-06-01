package com.example.onlineproducts.productdetails;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.onlineproducts.databinding.ActivityProductsDetailsBinding;

public class ProductsDetailsActivity extends AppCompatActivity {

    ActivityProductsDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductsDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        intent.getSerializableExtra("product");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Product Details");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}