package com.tuan04;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomGirdAdapter extends ArrayAdapter<Country> {

    public CustomGirdAdapter(@NonNull Context context, ArrayList<Country>arrayList) {
        super(context, 0,arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        HoderView view;
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.grid_item_layout,parent,false);
            view = new HoderView(convertView);
            convertView.setTag(view);
        }else{
            view=(HoderView) convertView.getTag();
        }
        Country country = getItem(position);
        view.imageView_flag.setImageResource(country.getId());
        view.textView_countryName.setText(country.getCountryName());
        view.textView_population.setText(country.getPopulation());
        return convertView;
    }

    public static class HoderView{
        private ImageView imageView_flag;
        private TextView textView_countryName;
        private TextView textView_population;
        public HoderView(View view){
            imageView_flag=view.findViewById(R.id.imageView_flag);
            textView_countryName=view.findViewById(R.id.textView_countryName);
            textView_population=view.findViewById(R.id.textView_population);
        }
    }
}
