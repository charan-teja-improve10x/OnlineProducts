package com.example.onlineproducts.carts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.onlineproducts.R;
import com.example.onlineproducts.databinding.ActivityCartsBinding;

public class CartsActivity extends AppCompatActivity {

    private ActivityCartsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}