package com.avery.libitum_androidproject.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.avery.libitum_androidproject.R;


public class PostDetailFragment extends Fragment {


    public PostDetailFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post_detail, container, false);
        ImageButton btnPlay =(ImageButton)view.findViewById(R.id.btnPlay);
        ImageButton btnPause =(ImageButton)view.findViewById(R.id.btnPause);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnPlay.setVisibility(view.INVISIBLE);
                btnPause.setVisibility(view.VISIBLE);
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnPlay.setVisibility(view.VISIBLE);
                btnPause.setVisibility(view.INVISIBLE);
            }
        });


        return view;
    }


}