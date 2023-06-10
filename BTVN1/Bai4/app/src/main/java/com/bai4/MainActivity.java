package com.bai4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtSoA,edtSoB;
    TextView tvKQ;
    Button btnTinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onCreated();
        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edtSoA.getText().toString());
                int b = Integer.parseInt(edtSoB.getText().toString());
                int kq = findUoc(a,b);
                String x = String.valueOf(kq);
                tvKQ.setText(" ");
                tvKQ.setText(tvKQ.getText() + " " + x);
                edtSoA.setText("");
                edtSoB.setText("");
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
        edtSoA = (EditText) findViewById(R.id.edtSoA);
        edtSoB = (EditText) findViewById(R.id.edtSoB);
        tvKQ = (TextView) findViewById(R.id.tvKQ);
        btnTinh=(Button) findViewById(R.id.btnKQ);

    }
}