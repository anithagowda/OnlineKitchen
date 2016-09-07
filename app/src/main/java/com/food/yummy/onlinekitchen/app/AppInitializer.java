package com.food.yummy.onlinekitchen.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by harry on 9/6/16.
 */
public class AppInitializer {

    private static AppInitializer mInstance;
    private static RequestQueue mRequestQueue;
    private static Context mContext;
    private static ImageLoader mImageLoader = null;

    private AppInitializer() {
        mRequestQueue = getVolleyRequestQueue();
        mImageLoader = new ImageLoader(mRequestQueue,
                new ImageLoader.ImageCache() {
                    private final LruCache<String, Bitmap>
                            cache = new LruCache<String, Bitmap>(20);

                    @Override
                    public Bitmap getBitmap(String url) {
                        return cache.get(url);
                    }

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        cache.put(url, bitmap);
                    }
                });

    }

    public static synchronized AppInitializer initInstance(Context context) {
        mContext = context;

        if (mInstance == null) {
            mInstance = new AppInitializer();
        }
        return mInstance;
    }

    public static AppInitializer getInstance() {
        return mInstance;
    }

    private RequestQueue getVolleyRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }
        return mRequestQueue;
    }

    public static ImageLoader getmImageLoader() {
        return mImageLoader;
    }

    public <T> void addToRequestQueue(Request<T> request) {
        request.setRetryPolicy(new DefaultRetryPolicy(8000,
                2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        getVolleyRequestQueue().add(request);
    }

    public void cancelFromRequestQueue(String tag) {
        getVolleyRequestQueue().cancelAll(tag);
    }

    public void terminate() {
        mRequestQueue.cancelAll(new RequestQueue.RequestFilter() {
            @Override
            public boolean apply(Request<?> request) {
                return true;
            }
        });
        mRequestQueue.stop();
    }
}
