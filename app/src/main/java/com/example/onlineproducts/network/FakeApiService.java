package com.example.onlineproducts.network;

import com.example.onlineproducts.carts.Cart;
import com.example.onlineproducts.carts.CartProduct;
import com.example.onlineproducts.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeApiService {
    @GET("api/v1/categories")
    Call<List<Product>> fetchCategories();

//    @GET("Products/category/{categoryName}")
//    Call<List<Product>> fetchProducts(@Path("categoryName") String categoryName);
//
//    @GET("products/{productId}")
//    Call<Product> fetchProductDetails(@Path("productId") int productId);
//
//    @GET("carts/{cartId}")
//    Call<Cart> fetchCartProducts(@Path("cartId") int cartId);
}
