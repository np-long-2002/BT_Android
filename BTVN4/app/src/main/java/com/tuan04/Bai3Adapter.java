package com.tuan04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Bai3Adapter extends RecyclerView.Adapter<Bai3Adapter.Bai3ViewHoder>{
    private Context context;
    private ArrayList<LangguageBai3> arrayList;
    public Bai3Adapter(Context context){
        this.context=context;
    }
    public void setData(ArrayList<LangguageBai3> data){
        this.arrayList=data;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public Bai3ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_row,parent,false);
        return new Bai3ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Bai3ViewHoder holder, int position) {
        LangguageBai3 bai3 = arrayList.get(position);
        if(bai3==null){
            return ;
        }
        holder.imgV3.setImageResource(bai3.getId());
        holder.name3.setText(bai3.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, bai3.name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if(arrayList!=null){
            return arrayList.size();
        }
        return 0;
    }

    public class Bai3ViewHoder extends RecyclerView.ViewHolder{
        private ImageView imgV3;
        private TextView name3;
        public Bai3ViewHoder(@NonNull View itemView) {
            super(itemView);
            imgV3 =itemView.findViewById(R.id.imgV3);
            name3=itemView.findViewById(R.id.name3);
        }
    }
}
