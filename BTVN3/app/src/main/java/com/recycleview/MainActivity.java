package com.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnHd,btnBai4,btnBaiHDJSON;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        btnHd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,recyclerview.class);
                startActivity(intent);
            }
        });
        btnBaiHDJSON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,recyclerviewjson.class);
                startActivity(intent);
            }
        });
        btnBai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,baitap4.class);
                startActivity(intent);
            }
        });
    }
    protected void addControl(){
        btnHd = (Button) findViewById(R.id.btnHd);
        btnBai4= (Button) findViewById(R.id.btnBai4);
        btnBaiHDJSON= (Button) findViewById(R.id.btnHDJSON);
    }
}