package com.avery.libitum_androidproject.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.avery.libitum_androidproject.R;
import com.avery.libitum_androidproject.postdata.LibitumPost;

import java.util.ArrayList;

public class MemberRecycleAdapter extends RecyclerView.Adapter<MemberRecycleAdapter.MemberHolder> {


    ArrayList<LibitumPost> listMember = new ArrayList<>();
    Context mContext;

    public class MemberHolder extends RecyclerView.ViewHolder{

        TextView tvViewPostTitle, tvViewPostMb;



        public MemberHolder(@NonNull View itemView) {
            super(itemView);

            tvViewPostTitle = itemView.findViewById(R.id.tvViewPostTitle);
            tvViewPostMb = itemView.findViewById(R.id.tvViewPostMb);

        }
    }

    public MemberRecycleAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MemberHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_listview, parent, false);
        MemberHolder holder = new MemberHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MemberHolder holder, int position) {

        holder.tvViewPostTitle.setText(listMember.get(position).getTitle());
        holder.tvViewPostMb.setText(listMember.get(position).getMemberName());


    }

    @Override
    public int getItemCount() {
        return listMember.size();
    }

    public void addItem(LibitumPost libitumPost){

        listMember.add(libitumPost);
        notifyDataSetChanged();
    }


}
