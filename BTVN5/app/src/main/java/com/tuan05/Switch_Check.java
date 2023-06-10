package com.tuan05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class Switch_Check extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
        Switch aSwitch =(Switch) findViewById(R.id.switch1);
        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(aSwitch.isChecked()){
                    TextView tv = findViewById(R.id.textView);
                    tv.setText(aSwitch.getText().toString());
                }else{
                    TextView tv = findViewById(R.id.textView);
                    tv.setText(aSwitch.getText().toString());
                }
            }
        });
    }
}