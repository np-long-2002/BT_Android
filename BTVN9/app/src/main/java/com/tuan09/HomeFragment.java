package com.tuan09;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;


public class HomeFragment extends Fragment {

    ListView lv_Container;

    ArrayList<Furniture> dataSource;
    public static FurnitureAdapter adapter;




    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    public HomeFragment(ArrayList<Furniture> dataSource) {

        this.dataSource = dataSource;

    }


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadViews(view);
        loadEvents();
        loadData();
    }

    protected void loadViews(View view)
    {
        lv_Container = view.findViewById(R.id.lv_Container);
    }

    protected void loadEvents()
    {
        lv_Container.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Utils.Ins().addItem(dataSource.get(position));
//                Toast.makeText(getContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();

                Furniture item = dataSource.get(position);
                Intent intent = new Intent(getContext(), Detail.class);
                intent.putExtra("Name", item.getName());
                intent.putExtra("FilenameImage", item.getFilenameImage());
                intent.putExtra("Description", item.getDescription());
                getContext().startActivity(intent);
            }
        });
    }

    protected void loadData()
    {
        if(dataSource == null)
        {
            dataSource = new ArrayList<>();
            Cursor cursor = Database.Ins().getCursorListAll(FurnitureDatabase.TABLE_FURNITURE);
            dataSource = Furniture.convertCursorToListObject(cursor);


            for (Furniture item: dataSource)
            {
                item.setImage(Furniture.convertStringToBitmapFromAsset(getContext(), item.getFilenameImage()));
            }

        }

        adapter = new FurnitureAdapter(R.layout.item_furniture, dataSource);
        lv_Container.setAdapter(adapter);
    }



}