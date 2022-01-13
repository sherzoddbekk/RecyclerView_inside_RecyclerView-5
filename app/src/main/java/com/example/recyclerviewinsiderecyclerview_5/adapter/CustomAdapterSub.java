package com.example.recyclerviewinsiderecyclerview_5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewinsiderecyclerview_5.R;
import com.example.recyclerviewinsiderecyclerview_5.model.MemberSub;

import java.util.List;

public class CustomAdapterSub extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<MemberSub> memberSubs;

    public CustomAdapterSub(Context context, List<MemberSub> memberSubs) {
        this.context = context;
        this.memberSubs = memberSubs;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View footer = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_view_sub,parent,false);
        return new CustomViewHolder(footer);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            MemberSub memberSub = memberSubs.get(position);
//            if(holder instanceof CustomViewHolder){
//                TextView name = ((CustomViewHolder) holder).name;
//
//            }
    }

    @Override
    public int getItemCount() {
        return memberSubs.size();
    }
    public  class CustomViewHolder extends RecyclerView.ViewHolder{
        View view;
//        TextView name;
//        RecyclerView recyclerView;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
           // recyclerView = view.findViewById(R.id.sub_view_layout_custom_item);
        }
    }
}
