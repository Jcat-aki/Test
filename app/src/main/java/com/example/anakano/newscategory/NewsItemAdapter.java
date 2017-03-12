package com.example.anakano.newscategory;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;
import java.util.Objects;

/**
 * Created by anakano on 17/03/13.
 */

public class NewsItemAdapter extends ArrayAdapter<NewsItem> {

    private List<NewsItem> mNewsItems;
    private LayoutInflater mInflater;


    public NewsItemAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount(){
        return mNewsItems.size();
    }

    @Override
    public NewsItem getItem(int position){
        return mNewsItems.get(position);
    }

    public void setData(List<NewsItem> newsItems){
        mNewsItems = newsItems;
    }
}
