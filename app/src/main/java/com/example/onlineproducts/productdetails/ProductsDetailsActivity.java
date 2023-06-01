package com.example.onlineproducts.productdetails;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.onlineproducts.databinding.ActivityProductsDetailsBinding;
import com.example.onlineproducts.models.Product;
import com.example.onlineproducts.network.FakeApi;
import com.example.onlineproducts.network.FakeApiService;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsDetailsActivity extends AppCompatActivity {

    ActivityProductsDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductsDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);
        // ActionBar actionBar = getSupportActionBar();
      //  actionBar.setTitle("Product Details");
      //  actionBar.setDisplayHomeAsUpEnabled(true);
        setProductDetails();
        fetchProductDetails(id);
    }

    private void setProductDetails() {
        Product product = new Product();
        binding.categoryNameTxt.setText(product.getCategory());
        binding.descriptionTxt.setText(product.getDescription());
        binding.productPriceTxt.setText(String.valueOf(product.getPrice()));
        binding.rateCountTxt.setText(String.valueOf(product.getRating().getCount()));
        binding.ratingTxt.setText(String.valueOf(product.getRating().getRate()));
        binding.productTitleTxt.setText(product.getTitle());
        Picasso.get().load(product.getImageUrl()).into(binding.posterIv);
    }

    private void fetchProductDetails(int id) {
        FakeApiService fakeApiService = new FakeApi().createFakeApi();
        Call<Product> call = fakeApiService.fetchProductDetails(id);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                Toast.makeText(ProductsDetailsActivity.this, "Response Success", Toast.LENGTH_SHORT).show();
                response.body();
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {

            }
        });
    }
}