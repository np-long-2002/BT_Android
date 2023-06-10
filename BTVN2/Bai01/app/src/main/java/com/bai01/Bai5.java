package com.bai01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Bai5 extends AppCompatActivity {
    ListView listView;
    ArrayList<Food> arrayList;
    FoodAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai5);
        listView = findViewById(R.id.dsFood);
        arrayList = Food.initFood();
        adapter = new FoodAdapter(Bai5.this, R.layout.layout_item_food, arrayList);
        listView.setAdapter(adapter);
    }
}