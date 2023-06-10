package com.tuan10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
//    ListView lvData;
//    private final static String TAG = "APP";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        FirebaseApp.initializeApp(this);
//        FirebaseDatabase db = FirebaseDatabase.getInstance();
//        DatabaseReference ref = db.getReference("test");
//        for (int i = 0; i <= 10; i++) {
//            ref.child("key_" + i).setValue("val " + i);
//        }
//        lvData = findViewById(R.id.lvData);
//        final ArrayList<String> name = new ArrayList<>();
//        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, name);
//        lvData.setAdapter(adapter);
//        ref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Log.i(TAG, "onDataChange: ");
//                Map<String, String> mapData = (Map<String, String>) snapshot.getValue();
//                name.clear();
//                name.addAll(mapData.values());
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Log.i(TAG, "onCancelled: ");
//            }
//        });
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference mData = db.getReference("MonHoc");
        MonHoc monhoc = new MonHoc("Android",4000000);
        mData.child("Khoahoc").setValue(monhoc);
        Map<String, String> mh = new HashMap<>();
        mh.put("monhoc", "IOS");
        mh.put("hocphi", "4500000");
        mData.child("Khoahoc2").setValue(mh);
        mData.child("Khoahoc3").push().setValue(mh);
        Map<String, Object> nickname = new HashMap<String, Object>();
        nickname.put("ghichu", "Android là hệ điều hành phổ biến trên điện thoại di động");
        mData.child("Khoahoc").updateChildren(nickname);
        mData.child("Khoahoc").removeValue();
    }
}
