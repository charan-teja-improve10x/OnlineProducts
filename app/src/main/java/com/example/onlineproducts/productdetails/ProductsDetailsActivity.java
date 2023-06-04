package com.example.onlineproducts.productdetails;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.onlineproducts.BaseActivity;
import com.example.onlineproducts.databinding.ActivityProductsDetailsBinding;
import com.example.onlineproducts.models.Product;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsDetailsActivity extends BaseActivity {

    private ActivityProductsDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductsDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        int id = intent.getIntExtra("productId", 0);
        getSupportActionBar().setTitle("Product Details");
        fetchProductDetails(id);
    }

    private void fetchProductDetails(int id) {
//        Call<Product> call = fakeApiService.fetchProductDetails(id);
//        call.enqueue(new Callback<Product>() {
//            @Override
//            public void onResponse(Call<Product> call, Response<Product> response) {
//                Product product = response.body();
//                binding.descriptionTxt.setText(product.getDescription());
//                binding.productPriceTxt.setText(String.valueOf(product.getPrice()));
//                binding.rateCountTxt.setText(String.valueOf(product.getRating().getCount()));
//                binding.ratingbarRb.setRating(product.getRating().getRate());
//                binding.ratingTxt.setText(String.valueOf(product.getRating().getRate()));
//                binding.productTitleTxt.setText(product.getTitle());
//                Picasso.get().load(product.getImageUrl()).into(binding.posterIv);
//            }
//
//            @Override
//            public void onFailure(Call<Product> call, Throwable t) {
//                Toast.makeText(ProductsDetailsActivity.this, "Failed", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}