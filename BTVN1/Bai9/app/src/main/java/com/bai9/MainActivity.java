package com.bai9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvKQ;
    EditText edtA,edtB;
    Button btnTong,btnHieu,btnTich,btnTh,btnUoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onCreated();
        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvKQ.setText(String.valueOf((Integer.parseInt(edtA.getText().toString()))+(Integer.parseInt(edtB.getText().toString()))));
            }
        });
        btnHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvKQ.setText(String.valueOf((Integer.parseInt(edtA.getText().toString()))-(Integer.parseInt(edtB.getText().toString()))));
            }
        });
        btnTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvKQ.setText(String.valueOf((Integer.parseInt(edtA.getText().toString()))*(Integer.parseInt(edtB.getText().toString()))));
            }
        });
        btnTh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvKQ.setText(String.valueOf((Double.parseDouble(edtA.getText().toString()))/(Double.parseDouble(edtB.getText().toString()))));
            }
        });
        btnUoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvKQ.setText(String.valueOf(findUoc((Integer.parseInt(edtA.getText().toString())),(Integer.parseInt(edtB.getText().toString())))));
            }
        });
    }
    private static int findUoc(int x, int y) {
        if(y== 0){
            return x;
        }
        return findUoc(y, x%y);
    }
    protected void onCreated()
    {
        tvKQ = (TextView) findViewById(R.id.tvKQ);
        edtA = (EditText) findViewById(R.id.edtA);
        edtB = (EditText) findViewById(R.id.edtB);
        btnTong =(Button) findViewById(R.id.btnTong);
        btnHieu =(Button) findViewById(R.id.btnHieu);
        btnUoc =(Button) findViewById(R.id.btnUoc);
        btnTich =(Button) findViewById(R.id.btnTich);
        btnTh =(Button) findViewById(R.id.btnTh);
    }
}