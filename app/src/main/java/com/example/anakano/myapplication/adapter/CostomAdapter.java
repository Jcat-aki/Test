package com.example.anakano.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import java.util.List;
import java.util.Objects;

/**
 * Created by anakano on 17/02/25.
 */
public class CostomAdapter extends ArrayAdapter {

    private static final int CATEGORY_ID = 1;
    private static final int CHILD_ID = 2;

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<Item> mItems;


    public CostomAdapter(Context context, int resource, List<Item> items ) {
        super(context, resource);

        mContext = context;
        mLayoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mItems = items;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int posotion){
        return mItems.get(posotion);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final int viewType = this.getItemViewType(position);

        if( viewType == CATEGORY_ID){ // カテゴリ名称

        }

        return convertView;
    }

    @Override
    public int getItemViewType(int position){
        Object item = this.getItem(position);

        if( item instanceof  CategoryItem){ // カテゴリ名称
            return CATEGORY_ID;
        }else if( item instanceof Item){ // リスト項目名称
            return CHILD_ID;
        }else {
            return 0;
        }
    }

    public class Item {

        public Item() {
        }
    }

    /**
     * カテゴリ名称用のクラス
     */
    public class CategoryItem extends Item{
        /** カテゴリ名称 */
        public String categoryName;

        public CategoryItem(){

        }
    }

    /**
     * カテゴリ項目内のクラス
     */
    public class ChildItem extends Item{
        /** 子要素の名称 */
        public String childName;

        public ChildItem(){

        }
    }
}
