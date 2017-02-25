package com.example.anakano.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private ProgressBar progressBar;

    public class APITask extends DownloadContent{

        protected void onPreExecute(){
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }


        protected void onPostExecute(ArrayList<Salon> salonArrayList){
            super.onPostExecute();
            progressBar.setVisibility(View.GONE);
            if( salonArrayList != null){
                String test = null;
                for ( Salon salon : salonArrayList){
                    test += salon.getShopName()+" ";
                }
                result.setText(test);
            } else if( exception != null ){
                Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar)findViewById(R.id.progress);
        result = (TextView)findViewById(R.id.apigetter);
        String url = "https://webservice.recruit.co.jp/beauty/salon/v1?order=3&key=9ea51cbdc743061f&address=%E9%8A%80%E5%BA%A7&format=json&count=5";
        new APITask().execute(url);
    }
}
