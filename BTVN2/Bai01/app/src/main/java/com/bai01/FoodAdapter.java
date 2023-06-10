package com.bai01;

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

public class FoodAdapter extends ArrayAdapter {
    Context context;
    ArrayList<Food> arrayList;
    int resource;
    public FoodAdapter(@NonNull Context context,int resource,@NonNull ArrayList<Food> arrayList){
        super(context,resource,arrayList);
        this.context=context;
        this.resource=resource;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Food food = arrayList.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, null);
        }

        ImageView img = convertView.findViewById(R.id.imgFood);
        TextView txtFoodType = convertView.findViewById(R.id.foodType);
        TextView txtFoodName = convertView.findViewById(R.id.foodName);
        TextView txtFoodPrice = convertView.findViewById(R.id.foodPrice);

        img.setImageResource(food.getId());
        txtFoodType.setText(food.getType());
        txtFoodName.setText(food.getName());
        String price = "RS " + food.getPrice();
        txtFoodPrice.setText(price);

        return convertView;
    }
}
