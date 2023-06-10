package com.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Bai01 extends AppCompatActivity {
    ListView ldscontact;
    ArrayList<String> arrayList;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai01);
        ldscontact = findViewById(R.id.lv01);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new docJSON().execute("https://run.mocky.io/v3/9f462969-0ac0-4fa3-8783-5c26d17f5ddf");
            }
        });
    }
    class docJSON extends AsyncTask<String,Integer,String>{
        @Override
        protected String doInBackground(String... params) {
            return docNoiDung_URL(params[0]);
        }
        @Override
        protected void onPostExecute(String o) {
            try {
                arrayList = new ArrayList<String>();
                JSONObject object =new JSONObject(o);
                JSONArray jsonArray = object.getJSONArray("contacts");
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject =jsonArray.getJSONObject(i);
                    arrayList.add(jsonObject.getString("id"));
                    arrayList.add(jsonObject.getString("name"));
                    arrayList.add(jsonObject.getString("email"));
                    arrayList.add(jsonObject.getString("phone"));
                }
                adapter =new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);
                ldscontact.setAdapter(adapter);
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