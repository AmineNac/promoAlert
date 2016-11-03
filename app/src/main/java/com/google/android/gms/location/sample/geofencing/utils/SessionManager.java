package com.google.android.gms.location.sample.geofencing.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.manaccache.mpdam.tunjobs.model.User;

/**
 * Created by Amine on 09/04/2015.
 */

public class SessionManager {

    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    Gson gson;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "SessionPrefs";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    public static final String KEY_USER = "user";

    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        gson = new Gson();
    }

    public void createLoginSession(User user) {

        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_USER, gson.toJson(user));
        Log.i("login", gson.toJson(user));
        editor.commit();
    }

    public Boolean checkLogin() {

        // Check login status
        if (!this.isLoggedIn()) {
            // user is not logged in redirect him to Login Activity
            // Intent i = new Intent(_context, LoginActivity.class);

            // Closing all the Activities
            //  i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            // i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // _context.startActivity(i);
            return true;
        }
        return false;
    }


    /**
     * Get stored session data
     */
    public User getClientDetails() throws JsonParseException {

        User user = gson.fromJson(pref.getString(KEY_USER, null), User.class);
        return user;
    }

    /**
     * Clear session details
     */
    public void logoutUser() {

        editor.clear();
        editor.commit();

    }

    /**
     * Quick check for login
     **/
    // Get Login State
    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }
/*
    public void redirectUserIfLoggedIn() {
        Intent i;
        if (this.isLoggedIn()) {
            try {
                if (this.getClientDetails().getIdentifiant() != null) {
                    i = new Intent(_context, AccueilUtilisateur.class);
                    _context.startActivity(i);
                }
            } catch (JsonParseException e) {
                e.printStackTrace();
            }
        } else {
            i = new Intent(_context, LoginActivity.class);
            _context.startActivity(i);
        }
    } */
}
