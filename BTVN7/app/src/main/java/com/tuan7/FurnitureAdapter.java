package com.tuan7;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class FurnitureAdapter extends ArrayAdapter<Furniture> {
    public FurnitureAdapter(@NonNull Context context, ArrayList<Furniture>arrayList) {
        super(context,0,arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        HolderView view;
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.item_list,parent,false);
            view=new HolderView(convertView);
            convertView.setTag(view);
        }else {
            view = (HolderView) convertView.getTag();
        }
        Furniture furniture= getItem(position);
        view.img.setImageResource(furniture.getImage());
        view.tv1.setText(furniture.getName());
        view.tv2.setText(furniture.getDescription());
        return convertView;
    }

    private class HolderView{
        private ImageView img;
        private TextView tv1,tv2;
        private HolderView(View view){
            img=view.findViewById(R.id.image);
            tv1=view.findViewById(R.id.tvname);
            tv2=view.findViewById(R.id.tvdes);
        }
    }
}
