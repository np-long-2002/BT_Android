package com.tuan7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class DashbordFragment extends Fragment {
    GridView girdView;
    ArrayList<Categories> arrayList;
    FurnitureAdapterGird furnitureAdapterGird;
    public DashbordFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_categories,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        girdView = view.findViewById(R.id.gird);
        arrayList = new Categories().getData();
        furnitureAdapterGird = new FurnitureAdapterGird(getContext(),arrayList);
        girdView.setAdapter(furnitureAdapterGird);
    }
}
