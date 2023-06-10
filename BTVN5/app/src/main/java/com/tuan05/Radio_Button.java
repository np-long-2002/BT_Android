package com.tuan05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Radio_Button extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        RadioButton rdo1 = findViewById(R.id.rdo1);
        RadioButton rdo2 = findViewById(R.id.rdo2);
        RadioButton rdo3 = findViewById(R.id.rdo3);
        RadioGroup rdoG = findViewById(R.id.rdoG);
        Button btnkq = findViewById(R.id.btnkq);
        TextView tvkq = findViewById(R.id.kq);
        btnkq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int check = rdoG.getCheckedRadioButtonId();
                if(check == R.id.rdo2){
                    tvkq.setText("Đúng");
                }else{
                    tvkq.setText("Sai");
                }
            }
        });
    }
}