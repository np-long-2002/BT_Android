package com.bai01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Bai1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        String[] values = getResources().getStringArray(R.array.myarrayHDH);
        ListView lv=(ListView)findViewById(R.id.dslv);
        ArrayAdapter<String> adap=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1,values);
        lv.setAdapter(adap);
    }
    public static final int myarray=0x7f0b0000;
}