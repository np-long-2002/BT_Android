package com.bai01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Bai031 extends AppCompatActivity {
    EditText edtNewEmail,edtNewPass,edtNewPassA;
    Button btnNew,btnHave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai031);
        addControl();
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bai031.this, Bai3.class);
                startActivity(intent);
            }
        });
        btnHave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bai031.this, Bai3.class);
                startActivity(intent);
            }
        });
    }
    protected void addControl(){
        btnNew=(Button) findViewById(R.id.btnNew);
        btnHave=(Button) findViewById(R.id.btnHave);
        edtNewEmail=(EditText) findViewById(R.id.edtNewEmail);
        edtNewPass=(EditText) findViewById(R.id.edtNewPass);
        edtNewPassA=(EditText) findViewById(R.id.edtNewPassA);
    }

}