package com.example.anakano.myapplication;

import android.os.AsyncTask;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by anakano on 16/07/24.
 */
public class DownloadContent extends AsyncTask<String,Void,ArrayList<Salon>>{
    Exception exception;

    @Override
    protected ArrayList<Salon> doInBackground(String... strings) {
        try {
            return RecuritAPI.getAPI(strings[0]);
        } catch (IOException e) {
            exception = e;
        }
        return null;
    }

    public void onPostExecute() {
    }
}
