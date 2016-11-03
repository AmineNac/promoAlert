package com.google.android.gms.location.sample.geofencing;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.location.sample.geofencing.model.Promo;
import com.google.android.gms.location.sample.geofencing.utils.LruBitmapCache;

import java.util.ArrayList;

/**
 * Created by MedAmine on 17/04/2016.
 */
public class myApp extends Application {

    public static final String TAG = myApp.class
            .getSimpleName();

    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    private static myApp mInstance;
    private ArrayList<Promo> listPromo;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        listPromo = new ArrayList<Promo>();
    }

    public static synchronized myApp getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    public ArrayList<Promo> getListOffres() {
        if (listPromo == null) {
            listPromo = new ArrayList<Promo>();
        }

        return listPromo;
    }

    public void setListOffres(ArrayList<Promo> list) {
        listPromo = list;
    }

    public ImageLoader getImageLoader() {
        getRequestQueue();
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(this.mRequestQueue,
                    new LruBitmapCache());
        }
        return this.mImageLoader;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
