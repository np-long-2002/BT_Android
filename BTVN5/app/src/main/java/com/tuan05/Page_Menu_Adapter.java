package com.tuan05;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Page_Menu_Adapter extends RecyclerView.Adapter<Page_Menu_Adapter.HoderView> {
    private Context context;
    private ArrayList<Page_Menu> arrayList;

    public Page_Menu_Adapter(Context context,ArrayList<Page_Menu> arrayList) {
        this.arrayList=arrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public HoderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcv_item,parent,false);
        return new HoderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HoderView holder, int position) {
        Page_Menu page_menu= arrayList.get(position);
        if(page_menu==null){
            return;
        }
        holder.name.setText(page_menu.getName());
    }

    @Override
    public int getItemCount() {
        if(arrayList!=null){
            return arrayList.size();
        }
        return 0;
    }

    public class HoderView extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name;
        RelativeLayout relativeLayout;
        public HoderView(@NonNull View view) {
            super(view);
            relativeLayout=view.findViewById(R.id.layout);
            name=view.findViewById(R.id.tvname);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent;
            int pos = getAdapterPosition();
            switch (pos){
                case 0:
                    intent = new Intent(context, Radio_Button.class);
                    context.startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(context, Check_Box.class);
                    context.startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(context, Chip_Group.class);
                    context.startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(context, Switch_Check.class);
                    context.startActivity(intent);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + pos);
            }
        }
    }
}
