package com.food.yummy.onlinekitchen.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.food.yummy.onlinekitchen.R;
import com.food.yummy.onlinekitchen.app.AppInitializer;
import com.food.yummy.onlinekitchen.app.ImageCache;
import com.food.yummy.onlinekitchen.dataModel.Recipe;
import com.food.yummy.onlinekitchen.database.FavoriteDB;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harry on 8/30/16.
 */
public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder>{

    private List<Recipe> recipes = new ArrayList<>();
    private Context mContext;
    private FavoriteDB favoriteDB = FavoriteDB.getInstance();

    public void setRecipesList(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public RecipeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.recipe_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Recipe recipe = recipes.get(position);
        final boolean isFavorite = favoriteDB.isPresentInDB(recipe);

        holder.title.setText(recipe.getTitle());
        holder.publisher.setText(recipe.getPublisher());

        if (ImageCache.inCache(recipe.getImageUrl())) {
            holder.image.setImageBitmap(ImageCache.getImage(recipe.getImageUrl()));
        }
        else {
            AppInitializer.getmImageLoader().get(recipe.getImageUrl(), new ImageLoader.ImageListener() {
                @Override
                public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                    holder.image.setImageBitmap(response.getBitmap());
                    ImageCache.cacheImage(recipe.getImageUrl(), response.getBitmap());
                }

                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
        }

        if (isFavorite) {
            holder.favorite.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.like));
        }
        else {
            holder.favorite.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.dislike));
        }

        holder.favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFavorite) {
                    holder.favorite.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.dislike));
                    favoriteDB.removeFavorite(recipe);
                }
                else {
                    holder.favorite.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.like));
                    favoriteDB.addFavorite(recipe);
                }
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, RecipeActivity.class);
                intent.putExtra("Recipe", recipe);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView publisher;
        private ImageView image;
        private ImageView favorite;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            publisher = (TextView) itemView.findViewById(R.id.publisher);
            image = (ImageView) itemView.findViewById(R.id.image);
            favorite = (ImageView) itemView.findViewById(R.id.toggle_fav);
        }
    }
}
