package com.avery.libitum_androidproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.avery.libitum_androidproject.PostDatailActivity;
import com.avery.libitum_androidproject.R;
import com.avery.libitum_androidproject.postdata.LibitumPost;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class LoginMemberPostAdapter extends RecyclerView.Adapter<LoginMemberPostAdapter.MemberHolder> {


    ArrayList<LibitumPost> listMember = new ArrayList<>();
    Context mContext;


    public class MemberHolder extends RecyclerView.ViewHolder{

        TextView tvViewPostTitle, tvViewPostMb, tvLoginPostTitle;
        String   musicPath ,postContext, postTitle, postMb , postDate;


        public MemberHolder(@NonNull View itemView) {
            super(itemView);

            tvLoginPostTitle = itemView.findViewById(R.id.tvLoginPostTitle);


            postDate  = "";
            musicPath ="";
            postContext = "";
            postTitle= "";
            postMb = "";
        }
    }

    public LoginMemberPostAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public LoginMemberPostAdapter.MemberHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_loginpostlist, parent, false);
        LoginMemberPostAdapter.MemberHolder holder = new LoginMemberPostAdapter.MemberHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull LoginMemberPostAdapter.MemberHolder holder, int position) {

        holder.tvLoginPostTitle.setText(listMember.get(position).getTitle());
//        holder.tvViewPostMb.setText(listMember.get(position).getMemberName());

        holder.postTitle = listMember.get(position).getTitle();
        holder.postMb = listMember.get(position).getMemberName();
        holder.postContext = listMember.get(position).getContent();
        holder.postDate = listMember.get(position).getCreateAt();
        holder.musicPath = listMember.get(position).getData1();



//     holder.musicPath.substring(holder.musicPath.lastIndexOf("/document/raw:/")+1);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {



            Date date = sdf.parse(holder.postDate);



            holder.postDate = sdf2.format(date);
            date = sdf2.parse(holder.postDate);

            cal.setTime(date);
            cal.add(Calendar.MINUTE, 540);

            holder.postDate = sdf2.format(cal.getTime());


        } catch (ParseException e) {
            e.printStackTrace();
        }


//        holder.postDate.format("YYYY-MM-DD");


        holder.tvLoginPostTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                Intent intent = new Intent(view.getContext(), PostDatailActivity.class);
//                intent.putExtra("postTitle", holder.postTitle);

//                bundle.putString("postTitle", holder.postTitle);
//                bundle.putString("postMb", holder.postMb);
//                bundle.putString("postContext", holder.postContext);
//                bundle.putString("postDate", holder.postDate);
//                bundle.putString("musicPath", holder.musicPath);

                intent.putExtra("postTitle", holder.postTitle);
                intent.putExtra("postMb", holder.postMb);
                intent.putExtra("postContext", holder.postContext);
                intent.putExtra("postDate", holder.postDate);
                intent.putExtra("musicPath", holder.musicPath);

//                postDatailActivity.setArguments(bundle);



                mContext.startActivity(intent);

//                Toast.makeText(view.getContext(), "구현중인 기능입니다!",Toast.LENGTH_SHORT).show();

            }
        });

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
