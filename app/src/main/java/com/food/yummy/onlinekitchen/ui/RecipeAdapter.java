package com.food.yummy.onlinekitchen.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.food.yummy.onlinekitchen.R;
import com.food.yummy.onlinekitchen.dataModel.Recipe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harry on 8/30/16.
 */
public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder>{

    private List<Recipe> recipes = new ArrayList<>();

    public void setRecipesList(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public RecipeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.recipe_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Recipe recipe = recipes.get(position);
        holder.title.setText(recipe.getTitle());
        holder.publisher.setText(recipe.getPublisher());
        //TODO: Fetch image
        //holder.image.setImageBitmap();
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView publisher;
        private ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            publisher = (TextView) itemView.findViewById(R.id.publisher);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
