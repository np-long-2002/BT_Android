package com.tuan7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Bai02 extends AppCompatActivity {
    BottomNavigationView navigationView;
    boolean stABoolean = false;
    MenuItem menuItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai02);
        navigationView=findViewById(R.id.nav_view);
        loadFragment(new HomeFragment());
        navigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        navigationView.setSelectedItemId(R.id.nav_view);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()){
                case R.id.DashboardFragment:
                    getSupportActionBar().setTitle("Dashboard");
                    fragment = new DashbordFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.HomeFragment:
                    getSupportActionBar().setTitle("Home");
                    fragment = new DashbordFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.NotifcationFagment:
                    getSupportActionBar().setTitle("Notifcation");
                    fragment = new DashbordFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };
    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}