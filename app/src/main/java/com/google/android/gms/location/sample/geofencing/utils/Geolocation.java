package com.google.android.gms.location.sample.geofencing.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by MedAmine on 22/04/2016.
 */
public class Geolocation {

    public static Location positionActuelle;

    // la position actuelle de l'utilisateur
    public static Location getPosition(Context context) {

        try {

            LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

            LocationListener locationListener = new LocationListener() {
                public void onLocationChanged(Location location) {
                    // Called when a new location is found by the location provider.
                    positionActuelle = location;
                    Log.i("newloc : ", positionActuelle.toString());
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            };

            String provider;

            if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
                provider = LocationManager.GPS_PROVIDER;
            else
                provider = LocationManager.NETWORK_PROVIDER;

            locationManager.requestLocationUpdates(provider, 30000, 0, locationListener);

            // Getting Current Location
            positionActuelle = locationManager.getLastKnownLocation(provider);
            Log.i("locloc", positionActuelle.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return positionActuelle;
    }
}
