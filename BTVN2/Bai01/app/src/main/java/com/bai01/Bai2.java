package com.bai01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Bai2 extends AppCompatActivity {

    ListView lvFlags;
    ArrayList<ItemFlag> values = new ArrayList<ItemFlag>();
    CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        lvFlags=(ListView) findViewById(R.id.lvFlags);

        values = addData();

        customAdapter = new CustomAdapter(Bai2.this, R.layout.layout_item_flag,values);
        lvFlags.setAdapter(customAdapter);


    }
    public ArrayList<ItemFlag> addData()
    {
        ArrayList<ItemFlag> arrayList=new ArrayList<ItemFlag>();
        String[]lsNation = getResources().getStringArray(R.array.lsNation);
        int[]lsId = new int[]{R.drawable.vietnam,R.drawable.laos, R.drawable.france, R.drawable.italy,R.drawable.ecuador};
        for(int i=0; i<lsId.length; i++) {
            ItemFlag f = new ItemFlag(lsId[i], lsNation[i]);
            arrayList.add(f);
        }
        return  arrayList;
    }
}