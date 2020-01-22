package com.abbi.practics1.Recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abbi.practics1.R;

import java.util.ArrayList;

public class MyFirstAdapter extends RecyclerView.Adapter<MyFirstAdapter.DataViewHolder> {

    ArrayList<DataItem> datalist;

    public MyFirstAdapter(ArrayList<DataItem> dt) {
        this.datalist = dt;
    }

    @NonNull
    @Override
    public MyFirstAdapter.DataViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View dv = LayoutInflater.from(viewGroup.getContext ()).inflate(R.layout.itemlist,viewGroup,false);
        return new DataViewHolder(dv);
    }

    @Override
    public void onBindViewHolder(@NonNull MyFirstAdapter.DataViewHolder dataViewHolder, int i) {
        dataViewHolder.tv.setText(datalist.get(i).getName());
        dataViewHolder.tv2.setText(datalist.get(i).getPhonenumber());
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }
    class DataViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv;
        TextView tv2;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.textView4);
            tv2 = itemView.findViewById(R.id.textView5);
        }
    }
}
