package com.example.onlineproducts.carts;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Cart {

    private Integer id;
    private Integer userId;
    private String date;
    @SerializedName("products")
    private List<CartProduct> cartProducts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }
}
