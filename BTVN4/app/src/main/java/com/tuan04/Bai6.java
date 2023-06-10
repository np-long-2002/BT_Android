package com.tuan04;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Bai6 extends AppCompatActivity {
    Button btnAll,btnClear,btnGet;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai6);
        GridView Gview = findViewById(R.id.gv6);
        ImageAdapter adapter = new ImageAdapter(Bai6.this,new Image().getdata());
        Gview.setAdapter(adapter);
        btnAll=findViewById(R.id.btnAll);
        btnClear=findViewById(R.id.btnClear);
        btnGet = findViewById(R.id.btnGet);
        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Gview.getAdapter().getCount();
                for(int i=0;i<count;i++){
                    ConstraintLayout item = (ConstraintLayout) Gview.getChildAt(i);
                    CheckBox checkBox = (CheckBox) item.findViewById(R.id.cb);
                    checkBox.setChecked(true);
                }
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Gview.getAdapter().getCount();
                for(int i=0;i<count;i++){
                    ConstraintLayout item = (ConstraintLayout) Gview.getChildAt(i);
                    CheckBox checkBox = (CheckBox) item.findViewById(R.id.cb);
                    checkBox.setChecked(false);
                }
            }
        });
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Gview.getAdapter().getCount();
                for(int i=0;i<count;i++){
                    ConstraintLayout item = (ConstraintLayout) Gview.getChildAt(i);
                    CheckBox checkBox = (CheckBox) item.findViewById(R.id.cb);
                    if(checkBox.isChecked()){
                        Toast.makeText(Bai6.this, checkBox.getText(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}