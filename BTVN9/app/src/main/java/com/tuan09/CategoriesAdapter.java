package com.tuan09;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CategoriesAdapter extends BaseAdapter {

    int layout;
    ArrayList<Categories> dataSource;


    public CategoriesAdapter(int layout, ArrayList<Categories> dataSource) {
        this.layout = layout;
        this.dataSource = dataSource;
    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Categories item =dataSource.get(position);

        if(convertView == null)
            convertView = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);

        ImageView img = convertView.findViewById(R.id.img);
        TextView tv_Title = convertView.findViewById(R.id.tv_Title);

        img.setImageBitmap(item.getImage());
        tv_Title.setText(item.getName());

        return convertView;
    }
}
