package com.example.onlineproducts.models;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {

    private Integer id;
    private String name;

    private List<String> images;

    private String title;
    private Float price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getImages(int i) {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
