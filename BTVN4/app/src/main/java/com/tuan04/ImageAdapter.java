package com.tuan04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ImageAdapter extends ArrayAdapter<Image> {
    public ImageAdapter(@NonNull Context context, ArrayList<Image> images) {
        super(context,0,images);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        HolderView view;
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.layout_gird_checkbox,parent,false);
            view=new HolderView(convertView);
            convertView.setTag(view);
        }else {
            view = (HolderView) convertView.getTag();
        }
        Image image= getItem(position);
        view.imgV6.setImageResource(image.getId());
        view.checkBox.setText(image.getNameCheck());
        return convertView;
    }

    private class HolderView{
        private ImageView imgV6;
        private CheckBox checkBox;
        private HolderView(View view){
            imgV6=view.findViewById(R.id.imgV6);
            checkBox=view.findViewById(R.id.cb);
        }
    }

}
