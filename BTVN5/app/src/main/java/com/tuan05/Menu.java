package com.tuan05;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.Toast;

public class Menu extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private Button btn,btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btn = findViewById(R.id.btnContextMenu);
        registerForContextMenu(btn);
        btn1=findViewById(R.id.btnPopupMenu);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(Menu.this,view);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.show();
            }
        });
        RecyclerView rcv = findViewById(R.id.rcv);
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        Page_Menu_Adapter adapter = new Page_Menu_Adapter(Menu.this,new Page_Menu().getData());
        rcv.setLayoutManager(linearLayoutManager);
        rcv.setAdapter(adapter);

    }
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        MenuItem menuItem = menu.findItem(R.id.item1);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.item2:
                Toast.makeText(getBaseContext(),"item2",Toast.LENGTH_LONG).show();
                break;
            case R.id.item3:
                Toast.makeText(getBaseContext(),"item3",Toast.LENGTH_LONG).show();
                break;
            case R.id.item4:
                Toast.makeText(getBaseContext(),"item4",Toast.LENGTH_LONG).show();
                break;
            case R.id.item5:
                Toast.makeText(getBaseContext(),"item5",Toast.LENGTH_LONG).show();
                break;
            case R.id.item6:
                Toast.makeText(getBaseContext(),"item6",Toast.LENGTH_LONG).show();
                break;
            case R.id.item6_1:
                Toast.makeText(getBaseContext(),"item6.1",Toast.LENGTH_LONG).show();
            case R.id.item6_2:
                Toast.makeText(getBaseContext(),"item6.2",Toast.LENGTH_LONG).show();
            default:
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo
            menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v == btn){
            getMenuInflater().inflate(R.menu.context_menu,menu);
        }
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.context1:
                Toast.makeText(getBaseContext(),"context1",Toast.LENGTH_LONG).show();
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id){
            case R.id.mail:
                Toast.makeText(getBaseContext(), "mail", Toast.LENGTH_SHORT).show();
            case R.id.upload:
                Toast.makeText(getBaseContext(), "upload", Toast.LENGTH_SHORT).show();
            case R.id.share:
                Toast.makeText(getBaseContext(), "share", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}