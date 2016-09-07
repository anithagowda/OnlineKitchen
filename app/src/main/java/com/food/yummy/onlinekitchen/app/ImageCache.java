package com.food.yummy.onlinekitchen.app;

import android.graphics.Bitmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by harry on 9/7/16.
 */
public class ImageCache {
    private static Map<String, Bitmap> imageCache = new HashMap<>();

    public static void cacheImage(String url, Bitmap image) {
        imageCache.put(url, image);
    }

    public static boolean inCache(String url) {
        return (imageCache.get(url) != null);
    }

    public static Bitmap getImage(String url) {
        return imageCache.get(url);
    }
}
