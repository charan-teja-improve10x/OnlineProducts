package com.example.onlineproducts.carts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.onlineproducts.BaseActivity;
import com.example.onlineproducts.R;
import com.example.onlineproducts.databinding.ActivityCartsBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartsActivity extends BaseActivity {

    private ActivityCartsBinding binding;
    private CartProductsAdapter cartProductsAdapter;
    private List<CartProduct> cartProducts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupAdapter();
        connectAdapter();
    }

    private void setupAdapter() {
        cartProductsAdapter = new CartProductsAdapter(cartProducts);
    }

    private void connectAdapter() {
        binding.cartsRv.setLayoutManager(new LinearLayoutManager(this));
        binding.cartsRv.setAdapter(cartProductsAdapter);
    }

    private void fetchCartProducts(int cartId) {
      Call<CartProduct> call =  fakeApiService.fetchCartProducts(cartId);
      call.enqueue(new Callback<CartProduct>() {
          @Override
          public void onResponse(Call<CartProduct> call, Response<CartProduct> response) {
              cartProductsAdapter.setCartProducts((List<CartProduct>) response.body());
          }

          @Override
          public void onFailure(Call<CartProduct> call, Throwable t) {
              Toast.makeText(CartsActivity.this, "Fetch Failed", Toast.LENGTH_SHORT).show();
          }
      });
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchCartProducts(1);
    }
}