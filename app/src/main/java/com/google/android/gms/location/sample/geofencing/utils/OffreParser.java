package com.google.android.gms.location.sample.geofencing.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class OffreParser {
/*
    public static ArrayList<Offre> parseData(String content) {
        ArrayList<Offre> offresList = new ArrayList<Offre>();

        try {
            JSONArray ar = new JSONArray(content);

            for (int i = 0; i < ar.length(); i++) {
                JSONObject obj = ar.getJSONObject(i);
                Offre offre = new Offre();
                offre.setTitre(obj.getString("titre"));
                offre.setExperience(obj.getInt("experience"));
                String[] coords = obj.getString("coordonnees_gps").split(",");
                offre.setLongitude(Double.parseDouble(coords[0]));
                offre.setLatitude(Double.parseDouble(coords[1]));
                offre.setAdresse(obj.getString("adresse"));
                offre.setDesc_emp(obj.getString("desc_emp"));
                offre.setTelephone(obj.getString("telephone"));
                offre.setSite_web(obj.getString("site_web"));
                offre.setLibelle(obj.getString("libelle"));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                offre.setDate_publication(sdf.parse(obj.getString("date_publication")));
                offre.setDate_expiration(sdf.parse(obj.getString("date_expiration")));
                offre.setNom_entreprise(obj.getString("nom_entreprise"));
                offre.setNbr_candidature(obj.getInt("nbr_candidature"));
                offre.setDescription(obj.getString("description"));
                offre.setEmail(obj.getString("email"));

                offresList.add(offre);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return offresList;
    }
*/
}
