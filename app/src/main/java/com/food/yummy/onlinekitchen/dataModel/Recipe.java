package com.food.yummy.onlinekitchen.dataModel;

/**
 * Created by harry on 8/30/16.
 */
public class Recipe {
    private String title;
    private String publisher;
    private String image;

    public Recipe(String title, String publisher, String image) {
        this.title = title;
        this.publisher = publisher;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getImage() {
        return image;
    }
}
