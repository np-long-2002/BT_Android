package com.bai5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtA,edtB;
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
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                tvKQ.setText("");
                if(a==0) {
                    if (b == 0)
                    {
                        tvKQ.setText("Phương Trình Có Vô Số Nghiệm .");
                    }else{
                        tvKQ.setText("Phương Trình Vô Nghiệm");
                    }
                }else{
                    double kq = (double) -b/a;
                    String s = String.valueOf(kq);
                    tvKQ.setText(tvKQ.getText()+"Phương Trình Có Nghiệm : "+s);
                }
            }
        });
    }

    protected void onCreated()
    {
        edtA = (EditText) findViewById(R.id.edtA);
        edtB = (EditText) findViewById(R.id.edtB);
        tvKQ = (TextView) findViewById(R.id.tvKQ);
        btnTinh = (Button) findViewById(R.id.btnTinh);
    }
    }
