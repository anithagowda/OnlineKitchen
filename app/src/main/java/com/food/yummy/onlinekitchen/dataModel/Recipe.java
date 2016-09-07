package com.food.yummy.onlinekitchen.dataModel;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by harry on 8/30/16.
 */
public class Recipe implements Parcelable {
    private String title;
    private String publisher;
    private String image_url;
    private String recipe_id;
    private String source_url;

    public Recipe(String title, String publisher, String image, String recipe_id, String source_url) {
        this.title = title;
        this.publisher = publisher;
        this.image_url = image;
        this.recipe_id = recipe_id;
        this.source_url = source_url;
    }

    protected Recipe(Parcel in) {
        title = in.readString();
        publisher = in.readString();
        image_url = in.readString();
        recipe_id = in.readString();
        source_url = in.readString();
    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getImageUrl() {
        return image_url;
    }

    public String getRecipeId() {
        return recipe_id;
    }

    public String getSourceUrl() {
        return source_url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(publisher);
        dest.writeString(image_url);
        dest.writeString(recipe_id);
        dest.writeString(source_url);
    }
}
