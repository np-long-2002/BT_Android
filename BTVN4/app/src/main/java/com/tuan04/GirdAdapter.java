package com.tuan04;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class GirdAdapter extends ArrayAdapter<Gird> {

    public GirdAdapter(@NonNull Context context, ArrayList<Gird> arrayList) {
        super(context,0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        HoderView view;
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.gird_bai5,parent,false);
            view=new HoderView(convertView);
            convertView.setTag(view);
        }
        else{
            view=(HoderView) convertView.getTag();
        }
        Gird gird = getItem(position);
        view.imgV5.setImageResource(gird.getId());
        view.name5.setText(gird.getName());
        return convertView;
    }

    private static class HoderView{
        private ImageView imgV5;
        private TextView name5;
        public HoderView(View view){
            imgV5 =view.findViewById(R.id.imgV5);
            name5=view.findViewById(R.id.name5);
        }
    }
}
