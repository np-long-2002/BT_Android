package com.bai01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<ItemFlag> arrayList;




    public CustomAdapter(@NonNull Context context, int resource, ArrayList<ItemFlag>arrayList) {
        super(context, resource,arrayList);
        this.context=context;
        this.resource=resource;
        this.arrayList=arrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ItemFlag itemFlag = arrayList.get(position);
        if(convertView==null)
        {
            convertView = LayoutInflater.from(context).inflate(resource,null);
        }
        ImageView img=(ImageView) convertView.findViewById(R.id.imgV);
        img.setImageResource(itemFlag.getId());
        TextView tvQg = (TextView) convertView.findViewById(R.id.tvQg);
        tvQg.setText(itemFlag.getName());

        return convertView;
    }
}
