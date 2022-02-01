package com.example.task_13.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;
import com.example.task_13.Model.Member;
import com.example.task_13.Adapter.RecyclerAdapter;
import com.example.task_13.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Context context;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    void initViews(){
        context =this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));

        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(context,R.anim.layout_animation_from_right);
        recyclerView.setLayoutAnimation(animation);

        ArrayList<Member> members = new ArrayList<>();

        for (int i=0;i<30;i++){
            members.add(new Member(R.mipmap.ic_profile,"Yahya " + i,"Mahmudiy " + i));
        }

        refreshAdapter(members);
    }

    public void openItemDetails(Member member){
        //Log.d("@@@","item is clicked"+member.getName());
        Toast.makeText(MainActivity.this,"You have clicked the item",Toast.LENGTH_SHORT).show();
    }

    void refreshAdapter(ArrayList<Member> members){
        RecyclerAdapter adapter = new RecyclerAdapter(this,members);
        recyclerView.setAdapter(adapter);
    }
}