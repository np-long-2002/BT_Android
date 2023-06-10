package com.tuan04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class Bai5 extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai5);
        GridView gridView=findViewById(R.id.gv);
        GirdAdapter adapter = new GirdAdapter(Bai5.this,new Gird().getData());
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(Bai5.this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Gird gird= (Gird) adapterView.getItemAtPosition(i);
        Toast.makeText(Bai5.this, gird.getName(), Toast.LENGTH_SHORT).show();
    }
}