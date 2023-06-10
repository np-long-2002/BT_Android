package com.tuan05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class Check_Box extends AppCompatActivity  implements View.OnClickListener {
    CheckBox ck1,ck2,ck3,ck4,ck5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        ck1=findViewById(R.id.ck1);
        ck2=findViewById(R.id.ck2);
        ck3=findViewById(R.id.ck3);
        ck4=findViewById(R.id.ck4);
        ck5=findViewById(R.id.ck5);
        ck1.setOnClickListener(this);
        ck2.setOnClickListener(this);
        ck3.setOnClickListener(this);
        ck4.setOnClickListener(this);
        ck5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ck1:
                if (ck1.isChecked())
                    Toast.makeText(getApplicationContext(), "Android", Toast.LENGTH_LONG).show();
                break;
            case R.id.ck2:
                if (ck2.isChecked())
                    Toast.makeText(getApplicationContext(), "Java", Toast.LENGTH_LONG).show();
                break;
            case R.id.ck3:
                if (ck3.isChecked())
                    Toast.makeText(getApplicationContext(), "PHP", Toast.LENGTH_LONG).show();
                break;
            case R.id.ck4:
                if (ck4.isChecked())
                    Toast.makeText(getApplicationContext(), "Python", Toast.LENGTH_LONG).show();
                break;
            case R.id.ck5:
                if (ck5.isChecked())
                    Toast.makeText(getApplicationContext(), "Unity", Toast.LENGTH_LONG).show();
                break;
        }
    }
}