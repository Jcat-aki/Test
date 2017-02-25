package com.example.anakano.myapplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by anakano on 16/07/24.
 */
public class RecuritAPI {


    public static ArrayList<Salon> getAPI(String url_name) throws IOException{

        URL url = new URL(url_name);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        StringBuilder stringBuilder = new StringBuilder();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }

        connection.disconnect();

        return jsonChanger(stringBuilder.toString());
    }

    public static ArrayList<Salon> jsonChanger(String contents){
        JSONObject jsonObject = null;
        ArrayList<Salon> salonlist = new ArrayList<Salon>();
        try {
            jsonObject = new JSONObject(contents);
            JSONArray hotpepperDataArray = jsonObject.getJSONObject("results").getJSONArray("shop");
            for ( int i = 0; i < hotpepperDataArray.length(); i++){
                JSONObject shopData = hotpepperDataArray.getJSONObject(i);
                Salon salon = new Salon();
                salon.setShopName(shopData.getString("name"));
                salon.setShopAccess(shopData.getString("access"));
                salon.setShopAddress(shopData.getString("address"));
                //salon.setShopImage(shopData.getJSONObject("main").getString(""));
                salon.setShopId(shopData.getString("id"));

                salonlist.add(salon);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return salonlist;
    }
}
