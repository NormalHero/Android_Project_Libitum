package com.avery.libitum_androidproject.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.avery.libitum_androidproject.MyProfileEditActivity;
import com.avery.libitum_androidproject.R;


public class MyFeedFragment extends Fragment {



    public MyFeedFragment() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_feed, container, false);

        ImageButton btnProfileSetting = view.findViewById(R.id.btnProfileSetting);
        btnProfileSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getActivity(), MyProfileEditActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}