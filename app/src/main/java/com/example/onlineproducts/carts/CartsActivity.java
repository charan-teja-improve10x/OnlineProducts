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
//      Call<Cart> call =  fakeApiService.fetchCartProducts(cartId);
//      call.enqueue(new Callback<Cart>() {
//          @Override
//          public void onResponse(Call<Cart> call, Response<Cart> response) {
//              cartProductsAdapter.setCartProducts(response.body().getCartProducts());
//          }
//
//          @Override
//          public void onFailure(Call<Cart> call, Throwable t) {
//              Toast.makeText(CartsActivity.this, "Fetch Failed", Toast.LENGTH_SHORT).show();
//          }
//      });
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchCartProducts(1);
    }
}