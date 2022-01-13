package com.example.recyclerviewinsiderecyclerview_5.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewinsiderecyclerview_5.R;
import com.example.recyclerviewinsiderecyclerview_5.model.Member;
import com.example.recyclerviewinsiderecyclerview_5.model.MemberSub;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM_VIEW = 0;
    private static final int TYPE_ITEM_LIST = 1;
    Context context;
    List<Member> members;

    public CustomAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
    }

    @Override
    public int getItemViewType(int position) {
        Member member = members.get(position);
        if(member.getMemberSubs() != null) return TYPE_ITEM_LIST;
        return TYPE_ITEM_VIEW;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == TYPE_ITEM_LIST){
            View header = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_custom_layout_list,viewGroup,false);
            return new CustomListHolder(header);
        }
        View footer = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_custom_layout_view,viewGroup,false);
        return new CustomViewHolder(footer);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Member member = members.get(position);
        if (holder instanceof CustomViewHolder){
            TextView name = ((CustomViewHolder)holder).name;
            name.setText(member.getFirstName()+ "  " + member.getLastName());
        }
        if (holder instanceof CustomListHolder){
        RecyclerView recyclerView = ((CustomListHolder) holder).recyclerView;
            Log.d("aaaa", "context: "+context);
            recyclerView.setLayoutManager(new GridLayoutManager(context,1));

        List<MemberSub> memberSubs = member.getMemberSubs();
        refreshAdapterSub(recyclerView,memberSubs);

        }
    }


    private  void refreshAdapterSub(RecyclerView recyclerView,List<MemberSub> memberSubs){
        CustomAdapterSub adapter  = new CustomAdapterSub(context,memberSubs);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    //holder here
    public class CustomViewHolder extends RecyclerView.ViewHolder{
            View view;
            TextView name;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            name = view.findViewById(R.id.view_layout_custom_item);
        }
    }


    public class CustomListHolder extends RecyclerView.ViewHolder{

        View view;
        RecyclerView recyclerView;

        public CustomListHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            recyclerView = view.findViewById(R.id.recycleViewlist);
        }
    }


}
