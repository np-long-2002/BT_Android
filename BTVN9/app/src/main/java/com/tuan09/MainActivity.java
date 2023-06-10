package com.tuan09;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    SearchView searchView;

    FrameLayout flContainer;
    public static BottomNavigationView navigation;

    Furniture adapter;

    public static ArrayList<Furniture> dataSource;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(255, 64, 129)));
        loadViews();
        loadEvents();
        loadData();
    }

    protected void insertDataToDatabase()
    {
        if(Furniture.convertCursorToListObject(Database.Ins().getCursorListAll(FurnitureDatabase.TABLE_FURNITURE)).size() == 0)
        {
            insertDataToTableFurniture();
        }
        if(Categories.convertCursorToListObject(Database.Ins().getCursorListAll(FurnitureDatabase.TABLE_CATEGORY)).size() == 0)
        {
            insertDataToTableCategory();
        }
    }

    protected void insertDataToTableCategory()
    {
        ArrayList<Categories> dataSource = new ArrayList<>();
        dataSource.add(new Categories(0, "Bed Room", "pic_4.jpg"));
        dataSource.add(new Categories(0, "Living Room", "pic_5.jpg"));
        dataSource.add(new Categories(0, "Meeting Room", "pic_6.jpg"));
        dataSource.add(new Categories(0, "Accessories", "pic_7.jpg"));

        for (Categories item: dataSource)
        {
            int temp = Database.Ins().insertRow(item.toContentValues(), FurnitureDatabase.TABLE_CATEGORY);
        }
    }

    protected void insertDataToTableFurniture()
    {
        ArrayList<Furniture> dataSource = new ArrayList<>();
        dataSource.add(new Furniture(0, 2, "Bàn nội thất siêu đẹp", "Đây là một chiếc bàn với 4 chân. Điểm nổi bật là được phủ lên" +
                " một màu trắng tinh khiết tạo cảm giác quý tộc.", "pic_1.jpg"));

        dataSource.add(new Furniture(0, 2,"Bàn nội thất siêu đẹp", "Đây là một chiếc bàn với 4 chân. Điểm nổi bật là được phủ lên" +
                " một màu trắng tinh khiết tạo cảm giác quý tộc.", "pic_2.jpg"));

        dataSource.add(new Furniture(0, 3,"Ghế nội thất siêu đẹp siêu cấp vip pro", "Đây là một chiếc ghế với 4 chân. Điểm nổi bật là được phủ lên" +
                " một màu trắng tinh khiết tạo cảm giác quý tộc.","pic_3.jpg"));

        dataSource.add(new Furniture(0, 1,"Giường nằm siêu đẹp siêu cấp vip pro", "Đây là một chiếc giường với 4 chân. Điểm nổi bật là được phủ lên" +
                " một màu trắng tinh khiết tạo cảm giác quý tộc. Điểm chút màu đen huyền bí.","pic_4.jpeg"));

        dataSource.add(new Furniture(0, 4,"Tủ đồ siêu cấp vip pro", "Đây là một tủ đựng đồ với 4 chân. Điểm nổi bật là được phủ lên" +
                " một màu trắng tinh khiết tạo cảm giác quý tộc.","pic_5.png"));

        for (Furniture item: dataSource)
        {
            int temp = Database.Ins().insertRow(item.toContentValues(), FurnitureDatabase.TABLE_FURNITURE);
        }
    }




    protected void loadViews()
    {
        flContainer = findViewById(R.id.fl_Container);
        navigation = findViewById(R.id.Navigation);
        addFragment(new HomeFragment());
    }

    protected void loadEvents()
    {
        navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.nav_Home:
                    {
                        if(dataSource == null)
                            addFragment(new HomeFragment());
                        else
                            addFragment(new HomeFragment(dataSource));
                        return true;
                    }
                    case R.id.nav_Dashboard:
                    {
                        dataSource = null;
                        addFragment(new DashboardFragment());
                        return true;
                    }
                    case R.id.nav_Notifications:
                    {
                        addFragment(new NotificationsFragment());
                        return true;
                    }
                }

                return false;
            }
        });


    }

    protected void loadData()
    {
        Database.Ins(MainActivity.this).openDatabase();
//        DataHelper.Ins().resetDatabase();
        insertDataToDatabase();



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.btnSearch).getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                HomeFragment.adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(MainActivity.this, newText, Toast.LENGTH_SHORT).show();
                HomeFragment.adapter.getFilter().filter(newText);

                return false;
            }
        });

        return true;
    }

    public void addFragment(Fragment target)
    {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(flContainer.getId(), target)
                .commit();
    }
}