package com.avery.libitum_androidproject.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.avery.libitum_androidproject.R;


public class InsertPostFragment extends Fragment {



    public InsertPostFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_insert_post, container, false);
        ImageButton btnActionInsertPost = view.findViewById(R.id.btnActionInsertPost);
        btnActionInsertPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"구현중인 기능입니다! (게시물 등록)",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}