package com.tuan04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

public class Bai3 extends AppCompatActivity {
    private RecyclerView rcv3;
    private Bai3Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        rcv3 =(RecyclerView) findViewById(R.id.rcv3);
        adapter=new Bai3Adapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Bai3.this,RecyclerView.VERTICAL,false);
        rcv3.setLayoutManager(linearLayoutManager);
        adapter.setData(getData());
        rcv3.setAdapter(adapter);
    }
    private ArrayList<LangguageBai3> getData(){
        ArrayList<LangguageBai3> arrList = new ArrayList<>();
        arrList.add(new LangguageBai3(R.drawable.c,"C# Language"));
        arrList.add(new LangguageBai3(R.drawable.html,"HTML Language"));
        arrList.add(new LangguageBai3(R.drawable.xml,"XML Language"));
        arrList.add(new LangguageBai3(R.drawable.php,"PHP Language"));
        return arrList;
    }
}