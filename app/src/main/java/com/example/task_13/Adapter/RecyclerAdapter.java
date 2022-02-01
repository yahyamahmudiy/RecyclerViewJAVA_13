package com.example.task_13.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.task_13.Activity.MainActivity;
import com.example.task_13.Model.Member;
import com.example.task_13.R;
import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    MainActivity activity;
    ArrayList<Member> members;

    public RecyclerAdapter(MainActivity activity, ArrayList<Member> members){
        this.activity = activity;
        this.members = members;
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new MemberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final Member member = members.get(position);

        if(holder instanceof MemberViewHolder){
            LinearLayout linearLayout = ((MemberViewHolder)holder).linearLayout;

            ImageView iv_profile = ((MemberViewHolder)holder).iv_profile;
            TextView tv_name = ((MemberViewHolder)holder).tv_name;
            TextView tv_surname = ((MemberViewHolder)holder).tv_surname;

            iv_profile.setImageResource(member.getProfile());
            tv_name.setText(member.getName());
            tv_surname.setText(member.getSurname());

            linearLayout.setOnClickListener((v)->{
                activity.openItemDetails(member);
            });
        }
    }

    public class MemberViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public ImageView iv_profile;
        public TextView tv_name;
        public TextView tv_surname;
        public LinearLayout linearLayout;

        public MemberViewHolder(View v){
            super(v);
            this.view = v;

            iv_profile = view.findViewById(R.id.iv_profile);
            tv_name = view.findViewById(R.id.tv_name);
            tv_surname = view.findViewById(R.id.tv_surname);
            linearLayout = view.findViewById(R.id.linearLayout);
        }
    }
}