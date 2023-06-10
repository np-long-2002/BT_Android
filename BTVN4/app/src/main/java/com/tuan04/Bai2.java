package com.tuan04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

import java.util.List;

public class Bai2 extends AppCompatActivity {
    private Spinner spinner;
    private List<Language> languages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        this.languages = Language.getLanguages();
        this.spinner = (Spinner) this.findViewById(R.id.spinner_language);
        CustomAdapterLanguage adapter = new CustomAdapterLanguage(Bai2.this, R.layout.spinner_item_layout_resource, R.id.textView_item_name, R.id.textView_item_percent, this.languages);
        this.spinner.setAdapter(adapter);
    }
}