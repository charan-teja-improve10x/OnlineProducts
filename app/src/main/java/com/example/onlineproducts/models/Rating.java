package com.example.onlineproducts.models;

public class Rating {
    private Float rate;
    private Integer count;

    public Float getRate() {
        return rate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }
}
