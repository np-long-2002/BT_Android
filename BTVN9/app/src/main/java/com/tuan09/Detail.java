package com.tuan09;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(255, 64, 129)));

        Bitmap image = Furniture.convertStringToBitmapFromAsset(Detail.this,
                getIntent().getStringExtra("FilenameImage"));
        String name = getIntent().getStringExtra("Name");
        String description = getIntent().getStringExtra("Description");

        ((TextView) findViewById(R.id.tvName)).setText(name);
        ((TextView) findViewById(R.id.tvDescription)).setText(description);
        ((ImageView) findViewById(R.id.img)).setImageBitmap(image);
    }
}