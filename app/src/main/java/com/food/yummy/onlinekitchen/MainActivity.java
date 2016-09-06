package com.food.yummy.onlinekitchen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.food.yummy.onlinekitchen.ui.TopRatedRecipeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchRecipe(View view) {
        Intent intent = new Intent(this, TopRatedRecipeActivity.class);
        startActivity(intent);
    }
}
