package com.recycleview;

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
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.Buffer;
import java.util.ArrayList;

public class baitap3 extends AppCompatActivity {
    ListView lv;
    ArrayList<String> ds ;
    ArrayAdapter adp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baitap3);
        lv=(ListView)findViewById(R.id.lv);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new docJSON().execute("https://www.mocky.io/v2/5a1e34412f00001d0dee2c54");
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
                ds = new ArrayList<String>();
                JSONObject root = new JSONObject(s);
                JSONArray array = root.getJSONArray("tkb");
                for(int i =0;i<array.length();i++){
                    JSONObject kq = array.getJSONObject(i);
                    ds.add(kq.getString("date"));
                    ds.add(kq.getString("subject"));
                    ds.add(kq.getString("begin"));
                    ds.add(kq.getString("Time"));
                    ds.add(kq.getString("Teacher"));
                }
                 adp = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,ds);
                lv.setAdapter(adp);
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