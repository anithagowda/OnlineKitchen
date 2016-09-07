package com.food.yummy.onlinekitchen.dataModel;

/**
 * Created by harry on 9/6/16.
 */
public class Food2ForkResponse {
    private int count;
    private Recipe[] recipes;

    public Food2ForkResponse(int count, Recipe[] recipes) {
        this.count = count;
        this.recipes = recipes;
    }

    public int getCount() {
        return count;
    }

    public Recipe[] getRecipes() {
        return recipes;
    }
}
