package com.tuan09;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;


public class DashboardFragment extends Fragment {

    GridView g_Container;
    CategoriesAdapter adapter;
    ArrayList<Categories> dataSource;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DashboardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashboardFragment_Bai2.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
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
        g_Container = view.findViewById(R.id.g_Container);
    }

    protected void loadEvents()
    {
        g_Container.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ArrayList<Furniture> listAll = new ArrayList<>();
                ArrayList<Furniture> listItem = new ArrayList<>();
                listAll = Furniture.convertCursorToListObject(Database.Ins().getCursorListAll(FurnitureDatabase.TABLE_FURNITURE));
                Categories curItem = dataSource.get(position);

                for(Furniture item: listAll)
                {
                    item.setImage(Furniture.convertStringToBitmapFromAsset(getContext(), item.getFilenameImage()));
                    if(item.getCategoryID() == curItem.getCategoryID())
                    {
                        listItem.add(item);
                    }
                }

                MainActivity.dataSource = listItem;
                MainActivity.navigation.setSelectedItemId(R.id.nav_Home);
            }
        });
    }

    protected void loadData()
    {
        dataSource = new ArrayList<>();

        Cursor cursor = Database.Ins().getCursorListAll(FurnitureDatabase.TABLE_CATEGORY);
        dataSource = Categories.convertCursorToListObject(cursor);
        for (Categories item: dataSource)
        {
            item.setImage(Categories.convertStringToBitmapFromAsset(getContext(), item.getFilenameImage()));
        }
        adapter = new CategoriesAdapter(R.layout.item_categories, dataSource);
        g_Container.setAdapter(adapter);
    }

}