package com.bai01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Bai41 extends AppCompatActivity {
    TextView tvName,tvCMND,tvTTT,tvSoThich,tvBang;
    Button btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai41);
        addControl();
        tvName.setText(getIntent().getStringExtra("name"));
        tvCMND.setText(getIntent().getStringExtra("cmnd"));
        tvBang.setText(getIntent().getStringExtra("rdoo"));
        tvSoThich.setText(getIntent().getStringExtra("ckb"));
        tvTTT.setText(getIntent().getStringExtra("edttt"));
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    protected void addControl(){
        tvName = (TextView) findViewById(R.id.tvName);
        tvCMND = (TextView) findViewById(R.id.tvCMND);
        tvTTT = (TextView) findViewById(R.id.tvTTT);
        tvSoThich = (TextView) findViewById(R.id.tvSoThich);
        tvBang = (TextView) findViewById(R.id.tvBang);
        btnExit=(Button) findViewById(R.id.btnExit);
    }

}