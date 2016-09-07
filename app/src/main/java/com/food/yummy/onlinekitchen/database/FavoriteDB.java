package com.food.yummy.onlinekitchen.database;

import com.food.yummy.onlinekitchen.dataModel.Recipe;

/**
 * Created by harry on 9/6/16.
 */
public class FavoriteDB {

    private static FavoriteDB mInstance = new FavoriteDB();

    private FavoriteDB() {
    }

    public static synchronized FavoriteDB getInstance() {
        if (mInstance == null) {
            mInstance = new FavoriteDB();
        }
        return mInstance;
    }

    public void addFavorite(Recipe recipe) {

    }

    public void removeFavorite(Recipe recipe) {

    }

    public boolean isPresentInDB(Recipe recipe) {
        return false;
    }
}
