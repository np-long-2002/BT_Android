package com.bai8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtC,edtF;
    Button btnF,btnC,btnClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onCreated();
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edtF.getText().toString());
                String s = String.valueOf(ConvertToF(a));
                edtC.setText("Nhiệt độ C là : " + s);
            }
        });
        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edtC.getText().toString());
                String s = String.valueOf(ConvertToC(a));
                edtF.setText("Nhiệt độ F là : " + s);
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtC.setText("");
                edtF.setText("");
            }
        });
    }
    public double ConvertToC(int a)
    {
        return a*(9/5)+32;
    }
    public double ConvertToF(int a)
    {
        return (a-32)*(5/9);
    }
    protected void onCreated()
    {
        edtC = (EditText) findViewById(R.id.edtC);
        edtF = (EditText) findViewById(R.id.edtF);
        btnF = (Button) findViewById(R.id.btnF);
        btnC = (Button) findViewById(R.id.btnC);
        btnClear = (Button) findViewById(R.id.btnClear);
    }
}