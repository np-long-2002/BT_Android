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

public class Bai03 extends AppCompatActivity {
    ListView ldsvietlott;
    ArrayList<VietLott> arrayList;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai03);
        ldsvietlott=findViewById(R.id.lv03);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new Bai03.docJSON().execute("https://data.ny.gov/resource/d6yy-54nr.json");
            }
        });
    }
    class docJSON extends AsyncTask<String,Integer,String> {
        @Override
        protected String doInBackground(String... params) {
            return docNoiDung_URL(params[0]);
        }
        @Override
        protected void onPostExecute(String o) {
            try {
                arrayList = new ArrayList<VietLott>();
                JSONArray jsonArray = new JSONArray(o);
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject =jsonArray.getJSONObject(i);
                    String ngay=jsonObject.getString("draw_date");
                    String so =jsonObject.getString("winning_numbers");
                    String soluong =jsonObject.getString("multiplier");
                    arrayList.add(new VietLott(ngay,so,soluong));
                }
                adapter =new Adapter(getApplicationContext(), arrayList);
                ldsvietlott.setAdapter(adapter);
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