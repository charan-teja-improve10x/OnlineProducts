package com.example.onlineproducts.network;

import com.example.onlineproducts.carts.CartProduct;
import com.example.onlineproducts.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeApiService {
    @GET("products/categories")
    Call<List<String>> fetchCategories();

    @GET("Products/category/{categoryName}")
    Call<List<Product>> fetchProducts(@Path("categoryName") String categoryName);

    @GET("products/{productId}")
    Call<Product> fetchProductDetails(@Path("productId") int productId);

    @GET("carts/{cartId}")
    Call<CartProduct> fetchCartProducts(@Path("cartId") int cartId);
}
