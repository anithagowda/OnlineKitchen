package com.food.yummy.onlinekitchen.service;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.food.yummy.onlinekitchen.app.AppInitializer;
import com.food.yummy.onlinekitchen.dataModel.Food2ForkResponse;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by harry on 9/6/16.
 */
public class RecipeService {

    private static final String food2fork_key = "ad9135a7fe9d7d36eb71c904328ccd66";
    private static final String searchUrl = "http://food2fork.com/api/search?key="+food2fork_key+"&format=json&callback=JSON_CALLBACK";
    private static final String getUrl = "http://food2fork.com/api/get?key="+food2fork_key+"&format=json&callback=JSON_CALLBACK";

    public static void getTopRatedRecipes() {

        StringRequest request = new StringRequest(Request.Method.GET, searchUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Food2ForkResponse result = new Gson().fromJson(response, Food2ForkResponse.class);
                        EventBus.getDefault().postSticky(result);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        EventBus.getDefault().postSticky(error);
                    }
                });
        AppInitializer.getInstance().addToRequestQueue(request);
    }
}
