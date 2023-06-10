package com.bai01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Bai4 extends AppCompatActivity {
    EditText edtName,edtCMND,edtTTT;
    Button btnSend;
    RadioGroup rdoG;
    RadioButton rdoselected;
    CheckBox ckb1,ckb2,ckb3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        addControl();
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextActivity();
            }
        });

    }
    protected void addControl(){
        edtName = (EditText) findViewById(R.id.edtName);
        edtCMND = (EditText) findViewById(R.id.edtCMND);
        edtTTT=(EditText) findViewById(R.id.edtTTT);
        btnSend = (Button) findViewById(R.id.btnSend);
        rdoG = (RadioGroup)findViewById(R.id.radioGroup);
        ckb1=(CheckBox) findViewById(R.id.ckb1);
        ckb2=(CheckBox) findViewById(R.id.ckb2);
        ckb3=(CheckBox) findViewById(R.id.ckb3);
    }
    private void nextActivity(){
        String name = edtName.getText().toString().trim();
        String cm = edtCMND.getText().toString().trim();
        String ttt = edtTTT.getText().toString().trim();
        int checkedR = rdoG.getCheckedRadioButtonId();
        if(checkedR!=-1){
            rdoselected =findViewById(checkedR);
        }
        String rdo = rdoselected.getText().toString().trim();
        String checkB = null;
        if(ckb1.isChecked()){
            checkB= ckb1.getText().toString().trim();
        }
        if(ckb2.isChecked()){
            if(checkB==null){
                checkB=ckb2.getText().toString().trim();
            }else{
                checkB+=","+ckb2.getText().toString().trim();
            }
        }
        if(ckb3.isChecked()){
            if(checkB==null){
                checkB=ckb3.getText().toString().trim();
            }else{
                checkB+=","+ckb3.getText().toString().trim();
            }
        }
        Intent intent = new Intent(Bai4.this, Bai41.class);
        intent.putExtra("name",name);
        intent.putExtra("cmnd",cm);
        intent.putExtra("rdoo",rdo);
        intent.putExtra("ckb",checkB);
        intent.putExtra("edttt",ttt);
        startActivity(intent);
    }

}