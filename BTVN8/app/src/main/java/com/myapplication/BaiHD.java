package com.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BaiHD extends AppCompatActivity {
    ListView fruitsList;
    String url = "https://gist.githubusercontent.com/BichNgan/18708326cbcc1086c071a502645d07d1/raw/235fd43bcfd797978a5c9e737c2510abf618f13c/fruits.json";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baihd);
        fruitsList = (ListView)findViewById(R.id.lv);
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                        parseJsonData(string);
                    }
                    }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError){
                Toast.makeText(getApplicationContext(), "Co loi", Toast.LENGTH_LONG).show();

            }
        });
        RequestQueue rQueue = Volley.newRequestQueue(BaiHD.this);
        rQueue.add(request);
    }
    void parseJsonData(String jsonString) {
        try {
            JSONObject object = new JSONObject(jsonString);
            JSONArray fruitsArray = object.getJSONArray("fruits");
            ArrayList al = new ArrayList();
            for(int i = 0; i < fruitsArray.length(); ++i) {
                al.add(fruitsArray.getString(i));
            }
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, al);
            fruitsList.setAdapter(adapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}