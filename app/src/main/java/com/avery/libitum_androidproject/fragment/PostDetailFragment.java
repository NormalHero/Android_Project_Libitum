package com.avery.libitum_androidproject.fragment;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ServiceConnection;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.avery.libitum_androidproject.R;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.Timer;
import java.util.TimerTask;


public class PostDetailFragment extends Fragment {

TextView tvpostTitle, tvpostDate, tvpostUserId, tvPostText;
SeekBar sbpostMedia;
ImageButton btnPlay, btnPause;
MediaPlayer mediaPlayer;

    public PostDetailFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post_detail, container, false);
        btnPlay =(ImageButton)view.findViewById(R.id.btnPlay);
        btnPause =(ImageButton)view.findViewById(R.id.btnPause);



      sbpostMedia = view.findViewById(R.id.sbpostMedia);
//        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.teq);
        String files ="/document/raw:/storage/emulated/0/Download/Bet_On_It.mp3";

     Uri uri = Uri.parse(files);

//                 sbpostMedia.setMax(mediaPlayer.getDuration());

//        ContentResolver resolver = getContext().getContentResolver();
//        String readOnlyMode = "r";
//        ParcelFileDescriptor pfd = null;
//        try {
//            pfd = resolver.openFileDescriptor(uri, readOnlyMode);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

// /document/raw:/storage/emulated/0/Download/1.wav
//        String files= "Download/1.wav";


        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnPlay.setVisibility(view.INVISIBLE);
                btnPause.setVisibility(view.VISIBLE);
                // 음원재생



                try {
                    mediaPlayer = new MediaPlayer();
//                    mediaPlayer.setDataSource(getContext(),Uri.parse("file://"+files));

                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//                    mediaPlayer.setDataSource(getContext(),Uri.parse(files));
                    mediaPlayer.setDataSource(getContext(),uri);
//                    mediaPlayer.setDataSource(files);
//                    mediaPlayer.prepareAsync();
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }




                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        mediaPlayer.start();
                    }
                });

//                    mediaPlayer = new MediaPlayer();
//                    mediaPlayer.setDataSource(files);
//                    mediaPlayer.prepare();
//                    mediaPlayer.start();
            }
        });


        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnPlay.setVisibility(view.VISIBLE);
                btnPause.setVisibility(view.INVISIBLE);
                // 음원 중지
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        mediaPlayer.pause();
                    }
                });

            }
        });


//
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                if(mediaPlayer.isPlaying()){
//                    sbpostMedia.setProgress(mediaPlayer.getCurrentPosition());
//
//                }
//
//            }
//        },0,100);


        return view;
    }




}