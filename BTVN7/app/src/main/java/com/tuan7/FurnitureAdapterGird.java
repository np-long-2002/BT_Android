package com.tuan7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class FurnitureAdapterGird extends ArrayAdapter<Categories> {
    public FurnitureAdapterGird(@NonNull Context context, ArrayList<Categories> arrayList) {
        super(context, 0,arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        HoderView view;
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.item_gird,parent,false);
            view = new HoderView(convertView);
            convertView.setTag(view);
        }else{
            view=(HoderView) convertView.getTag();
        }
        Categories categories = getItem(position);
        view.imageView.setImageResource(categories.getImage());
        view.textView.setText(categories.getName());
        return convertView;
    }

    public static class HoderView{
        private ImageView imageView;
        private TextView textView;
        public HoderView(View view){
            imageView=view.findViewById(R.id.imageds);
            textView=view.findViewById(R.id.tvds);
        }
    }
}
