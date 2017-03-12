package com.example.anakano.newscategory;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<NewsItem> items;
    private NewsItemAdapter mAdapter;
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();
        mAdapter = new NewsItemAdapter(this,R.layout.news_item);
        final ListView listView = (ListView) findViewById(R.id.main_api_response_listview);
        listView.setAdapter(mAdapter);

        mToast = new Toast(this);

        try {
            final URL url = new URL("https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty");
            DownloadTasks downloadTasks = (DownloadTasks) new DownloadTasks(new ProgressDialog(this), new OnCallback<List<NewsItem>>() {
                @Override
                public void onSuccess(List<NewsItem> newsItems) {
                    mAdapter.setData(newsItems);
                    mAdapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Exception e) {
                    mToast.setText(e.toString());
                    mToast.show();
                }
            }).execute(url);
        } catch (MalformedURLException e) {
            mToast.setText(e.toString());
            mToast.show();
            e.printStackTrace();
        }
    }



}
