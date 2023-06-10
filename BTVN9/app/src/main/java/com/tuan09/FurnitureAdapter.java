package com.tuan09;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class FurnitureAdapter extends BaseAdapter implements Filterable {

    int layout;
    ArrayList<Furniture> dataSource;

    ArrayList<Furniture> dataSourceBackup;

    public FurnitureAdapter(int layout, ArrayList<Furniture> dataSource) {
        this.layout = layout;
        this.dataSource = dataSource;
        this.dataSourceBackup = dataSource;
    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Furniture item = dataSource.get(position);

        if(convertView == null)
            convertView = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);

        ImageView img = convertView.findViewById(R.id.img);
        TextView tv_Title = convertView.findViewById(R.id.tv_Title);
        TextView tv_Des = convertView.findViewById(R.id.tv_Des);

        img.setImageBitmap(item.getImage());
        tv_Title.setText(item.getName());
        tv_Des.setText(item.getDescription());




        return convertView;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String key = constraint.toString();
                ArrayList<Furniture> resultSearch = new ArrayList<>();
                if(key.trim().isEmpty())
                {
                    dataSource = resultSearch = dataSourceBackup;
                }
                else
                {
                    for (Furniture item: dataSourceBackup)
                    {
                        if(item.getName().toLowerCase().contains(key.toLowerCase()))
                        {
                            resultSearch.add(item);
                        }
                    }
                    dataSource = resultSearch;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = resultSearch;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                dataSource = (ArrayList<Furniture>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}
