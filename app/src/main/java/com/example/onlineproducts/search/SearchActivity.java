package com.example.onlineproducts.search;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.onlineproducts.R;
import com.example.onlineproducts.databinding.ActivitySearchBinding;

public class SearchActivity extends AppCompatActivity {

    private ActivitySearchBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}