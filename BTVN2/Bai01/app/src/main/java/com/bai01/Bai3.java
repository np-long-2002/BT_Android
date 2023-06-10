package com.bai01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Bai3 extends AppCompatActivity {
    EditText edtEmail,edtPass;
    Button btnLogin,btnCreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai03);
        addControl();
        SharedPreferences spr = getPreferences(MODE_PRIVATE);
        edtEmail.setText(spr.getString("E", null));
        edtPass.setText(spr.getString("P", null));
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bai3.this, Bai031.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPause();
                finish();
            }
        });
    }
    protected void addControl(){
        btnCreate=(Button) findViewById(R.id.btnCreate);
        btnLogin=(Button) findViewById(R.id.btnLogin);
        edtEmail=(EditText) findViewById(R.id.edtEmail);
        edtPass=(EditText) findViewById(R.id.edtPass);
    }
    protected void onPause(){
        SharedPreferences spr = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = spr.edit();
        String email = edtEmail.getText().toString();
        String pass = edtPass.getText().toString();
        editor.putString("E", email);
        editor.putString("P", pass);
        editor.commit();
        super.onPause();
    }
}