package com.example.recyclerviewinsiderecyclerview_5.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.recyclerviewinsiderecyclerview_5.R;
import com.example.recyclerviewinsiderecyclerview_5.adapter.CustomAdapter;
import com.example.recyclerviewinsiderecyclerview_5.model.Member;
import com.example.recyclerviewinsiderecyclerview_5.model.MemberSub;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        List<Member> members = prepareMemberList();
        refreshAdapter(members);
    }
    private  void  initView(){
        context = this;
        recyclerView = findViewById(R.id.recycleMain);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
    }
    private void refreshAdapter(List<Member> members){
        CustomAdapter adapter = new CustomAdapter(context,members);
        recyclerView.setAdapter(adapter);
    }
    private List<Member> prepareMemberList(){
        List<Member> members = new ArrayList<>();
        members.add(new Member()); // for header
        for (int i = 0; i < 30; i++) {
            if (i == 2 || i == 10){
                members.add(new Member(i + ")Sherzod",i + ")Jurabekov",prepareSubMembers()));
            }else{
                members.add(new Member(i + ")Sarvar",i + ")Xalmatov",null));
            }
        }
        members.add(new Member()); //for footer
        return members;
    }
    private List<MemberSub> prepareSubMembers (){
        List<MemberSub> memberSubs =new  ArrayList();
        for (int i = 0; i < 5; i++) {
            memberSubs.add(new MemberSub());
        }
        return memberSubs;
    }
}