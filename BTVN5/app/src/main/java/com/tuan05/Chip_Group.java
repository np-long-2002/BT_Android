package com.tuan05;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.google.android.material.chip.Chip;

public class Chip_Group extends AppCompatActivity {
    EditText edt;
    private View.OnClickListener clickListener;
    private View.OnClickListener closeIconClickListener;
    private CompoundButton.OnCheckedChangeListener checkedChangeListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chip_group);
        Chip chip1 = findViewById(R.id.chip1);
        Chip chip2 = findViewById(R.id.chip2);
        Chip chip3 = findViewById(R.id.chip3);
        Chip chip4 = findViewById(R.id.chip4);
        Chip chip5 = findViewById(R.id.chip5);
        Button btn = findViewById(R.id.button);
        edt =findViewById(R.id.editTextTextPersonName);
        this.clickListener= new ClickListenerImpl();
        this.closeIconClickListener = new CloseIconClickListenerImpl();
        this.checkedChangeListener = new CheckedChangeListenerImpl();
        chip1.setOnClickListener(clickListener);
        chip1.setOnCloseIconClickListener(closeIconClickListener);
        chip1.setOnCheckedChangeListener(checkedChangeListener);
        chip2.setOnClickListener(clickListener);
        chip2.setOnCloseIconClickListener(closeIconClickListener);
        chip2.setOnCheckedChangeListener(checkedChangeListener);
        chip3.setOnClickListener(clickListener);
        chip3.setOnCloseIconClickListener(closeIconClickListener);
        chip3.setOnCheckedChangeListener(checkedChangeListener);
        chip4.setOnClickListener(clickListener);
        chip4.setOnCloseIconClickListener(closeIconClickListener);
        chip4.setOnCheckedChangeListener(checkedChangeListener);
        chip5.setOnClickListener(clickListener);
        chip5.setOnCloseIconClickListener(closeIconClickListener);
        chip5.setOnCheckedChangeListener(checkedChangeListener);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt.setText("");
            }
        });
    }
    @SuppressLint("RestrictedApi")
    private void appendLog(String text)  {
        this.edt.append(text) ;
        this.edt.append("\n");
        Log.i(LOG_TAG, text);
    }

    class  ClickListenerImpl implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            appendLog("Clicked");
        }
    }


    class CloseIconClickListenerImpl implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            appendLog("Close Icon Clicked");
        }
    }

    class CheckedChangeListenerImpl implements  CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            appendLog("Checked Changed! isChecked? " + isChecked);
        }
    }
}