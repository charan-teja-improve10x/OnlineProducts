package com.example.onlineproducts.products;

import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.onlineproducts.BaseActivity;
import com.example.onlineproducts.SearchItemActivity;
import com.example.onlineproducts.databinding.ActivityProductsBinding;
import com.example.onlineproducts.models.Product;
import com.example.onlineproducts.productdetails.ProductsDetailsActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends SearchItemActivity implements OnProductActionListener {

    private ActivityProductsBinding binding;
    private ProductsAdapter adapter;
    private List<Product> products = new ArrayList<>();
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        product = (Product) intent.getSerializableExtra("product");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Products");
        actionBar.setDisplayHomeAsUpEnabled(true);
        createAdapter();
        connectAdapter();
    }

    private void createAdapter() {
        adapter = new ProductsAdapter(products);
        adapter.setOnProductActionListener(this);
    }

    private void connectAdapter() {
        binding.productsRv.setLayoutManager(new GridLayoutManager(this, 2));
        binding.productsRv.setAdapter(adapter);
    }

    private void fetchProducts(Product product) {
        Call<List<Product>> call = fakeApiService.fetchProducts(product.getId());
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                setProgressBarVisible();
                adapter.createProducts(response.body());
                setProgressBarGone();
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(ProductsActivity.this, "Fetch Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onProductClick(int productId) {
        Intent intent = new Intent(this, ProductsDetailsActivity.class);
        intent.putExtra("productId", productId);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchProducts(product);
    }

    private void setProgressBarVisible() {
        binding.progressBar2.setVisibility(View.VISIBLE);
    }

    private void setProgressBarGone() {
        binding.progressBar2.setVisibility(View.GONE);
    }
}