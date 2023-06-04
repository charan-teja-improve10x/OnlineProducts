package com.example.onlineproducts;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.onlineproducts.carts.Cart;
import com.example.onlineproducts.carts.CartProduct;
import com.example.onlineproducts.models.Product;
import com.example.onlineproducts.network.FakeApi;
import com.example.onlineproducts.network.FakeApiService;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getCategories() throws IOException {
        FakeApiService fakeApiService = new FakeApi().createFakeApi();
        Call<List<Product>> call = fakeApiService.fetchCategories();
        List<Product> category = call.execute().body();
        assertNotNull(category);
        assertFalse(category.isEmpty());
        System.out.println(new Gson().toJson(category));
        }

        @Test
        public void getProducts() throws IOException {
        FakeApiService fakeApiService = new FakeApi().createFakeApi();
        Call<List<Product>> call = fakeApiService.fetchProducts(1);
        List<Product> products = call.execute().body();
        assertNotNull(products);
        assertFalse(products.isEmpty());
        System.out.println(new Gson().toJson(products));
        }

        @Test
        public void fetchProductDetails() throws IOException {
        FakeApiService fakeApiService = new FakeApi().createFakeApi();
        Call<Product> call = fakeApiService.fetchProductDetails(4);
        Product product = call.execute().body();
        assertNotNull(product);
        System.out.println(new Gson().toJson(product));
        }

        @Test
        public void getCartProduct () throws IOException {
//        FakeApiService fakeApiService = new FakeApi().createFakeApi();
//        Call<Cart> call = fakeApiService.fetchCartProducts(1);
//        Cart cart = call.execute().body();
//        assertNotNull(cart);
//        System.out.println(new Gson().toJson(cart));
        }
    }
