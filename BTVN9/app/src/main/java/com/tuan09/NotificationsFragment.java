package com.tuan09;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;


public class NotificationsFragment extends Fragment {

    ListView lv_Container;
    TextView tv_Notification;

    FurnitureAdapter adapter;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NotificationsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NotificationsFragment_Bai2.
     */
    // TODO: Rename and change types and number of parameters
    public static NotificationsFragment newInstance(String param1, String param2) {
        NotificationsFragment fragment = new NotificationsFragment();
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
        return inflater.inflate(R.layout.fragment_notifications, container, false);
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
        tv_Notification = view.findViewById(R.id.tv_Notification);
    }

    protected void loadEvents()
    {

    }

    protected void loadData()
    {
        ArrayList<Furniture> dataSource = Utils.Ins().getSelectedItems();

        if(dataSource.size() == 0)
        {
            showData(false);
            tv_Notification.setText("Chưa có sản phẩm nào đc bạn chọn ");
        }
        else
        {
            showData(true);
            adapter = new FurnitureAdapter(R.layout.item_furniture, dataSource);
            lv_Container.setAdapter(adapter);
        }

    }

    protected void showData(boolean isShow)
    {
        if(isShow)
        {
            lv_Container.setVisibility(View.VISIBLE);
            tv_Notification.setVisibility(View.INVISIBLE);
        }
        else
        {
            lv_Container.setVisibility(View.INVISIBLE);
            tv_Notification.setVisibility(View.VISIBLE);
        }
    }
}