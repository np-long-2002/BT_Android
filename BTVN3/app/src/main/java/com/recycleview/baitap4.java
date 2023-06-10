package com.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class baitap4 extends AppCompatActivity {
    ListView lv;
    ArrayList<String> arraylv;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baitap4);
        lv=(ListView) findViewById(R.id.lv);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new docJSON().execute("https://www.mocky.io/v2/5a2bc6952f0000ce0a03930e");
            }
        });
    }
    class docJSON extends AsyncTask<String,Integer,String >{
        @Override
        protected String doInBackground(String... params) {
            return docNoiDung_URL(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            try {
                arraylv = new ArrayList<String>();
                JSONObject root = new JSONObject(s);
                JSONArray array = root.getJSONArray("ketquas");
                for(int i =0;i<array.length();i++){
                    JSONObject kq = array.getJSONObject(i);
                    arraylv.add(kq.getString("MaMon"));
                    arraylv.add(kq.getString("TenMon"));
                    arraylv.add(kq.getString("TL"));
                    arraylv.add(kq.getString("GK"));
                    arraylv.add(kq.getString("CK"));
                }
                adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,arraylv);
                lv.setAdapter(adapter);
            } catch (Exception e) {
                Log.e("err", String.valueOf(e));
            }
        }
    }
    private static String docNoiDung_URL(String Url){
        StringBuilder content = new StringBuilder();

        try {
            URL url= new URL(Url);
            URLConnection urlConnection= url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine())!=null){
                content.append(line +"\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            Log.e("err", String.valueOf(e));
        }
        return content.toString();

    }
    }