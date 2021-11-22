package com.avery.libitum_androidproject.fragment;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

import com.avery.libitum_androidproject.R;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class InsertPostFragment extends Fragment {



    public InsertPostFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_insert_post, container, false);

        ImageButton btnFindMusic = view.findViewById(R.id.btnFindMusic);
        btnFindMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("audio/*");
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(Intent.createChooser(intent, "Open"));

                String FilePath = getContext().getApplicationInfo().dataDir + File.separator + System.currentTimeMillis();
                Log.d("###",FilePath);
                File file = new File(FilePath);


//                File file = null;
//                try{
//                    file = new File(getFi);
//                }catch (FileNotFoundException e){
//                    e.printStackTrace();
//                }catch (IOException e){
//                    e.printStackTrace();
//                }





            }
        });

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