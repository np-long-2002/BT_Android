package com.myapplication;

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

public class Adapter extends ArrayAdapter<VietLott> {
    public Adapter(@NonNull Context context, ArrayList<VietLott>arrayList) {
        super(context,0 ,arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        HoderView view;
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.layout_item,parent,false);
            view = new HoderView(convertView);
            convertView.setTag(view);
        }else{
            view=(HoderView) convertView.getTag();
        }
        VietLott vietLott=getItem(position);
        view.tvngay.setText(vietLott.getNgay());
        view.tvso.setText(vietLott.getSo());
        view.tvsl.setText(vietLott.getSoluong());
        return convertView;
    }

    public static class HoderView{
      private TextView tvngay,tvso,tvsl;
        public HoderView(View view){
           tvngay=view.findViewById(R.id.tvtg);
           tvso=view.findViewById(R.id.tvso);
           tvsl = view.findViewById(R.id.tvsl);
        }
    }
}
