package com.bai7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtDec;
    TextView tvkq;
    Button btnBin,btnHex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onCreated();
        btnBin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String a = Integer.toBinaryString(Integer.parseInt(edtDec.getText().toString()));
               tvkq.setText(a);
            }
        });
        btnHex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = Integer.toHexString(Integer.parseInt(edtDec.getText().toString()));
                tvkq.setText(a);
            }
        });
    }
    protected void onCreated()
    {
        edtDec = (EditText) findViewById(R.id.edtDec);
        tvkq =(TextView) findViewById(R.id.tvkq);
        btnBin=(Button) findViewById(R.id.btnBin);
        btnHex=(Button) findViewById(R.id.btnHex);
    }
}