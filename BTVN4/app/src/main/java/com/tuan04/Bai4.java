package com.tuan04;

import static android.graphics.Color.BLUE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class Bai4 extends AppCompatActivity implements AdapterView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        GridView gridView = findViewById(R.id.gridView);
        CustomGirdAdapter adapter = new CustomGirdAdapter(Bai4.this, new Country().getListData());
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(Bai4.this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Country country =(Country) adapterView.getItemAtPosition(i);
        view.setBackgroundResource(R.color.purple_500);;
        Toast.makeText(Bai4.this, country.getCountryName()+" has "+country.getPopulation()+" population", Toast.LENGTH_SHORT).show();
    }
}