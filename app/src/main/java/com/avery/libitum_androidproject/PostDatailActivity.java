package com.avery.libitum_androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class PostDatailActivity extends AppCompatActivity {

    ImageButton btnPlay,btnPause;
    TextView tvpostTitle, tvpostDate, tvpostUserId, tvPostText;
    SeekBar sbpostMedia;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_datail);
        btnPlay =findViewById(R.id.btnPlay);
        btnPause =findViewById(R.id.btnPause);

        Intent intent = getIntent();

//        String files ="/storage/emulated/0/Download/1.wav";

        tvpostTitle= findViewById(R.id.etPostTitle);
        tvpostDate= findViewById(R.id.tvpostDate);
        tvpostUserId= findViewById(R.id.tvpostUserId);

        tvPostText= findViewById(R.id.tvPostText);

            tvpostTitle.setText(intent.getStringExtra("postTitle"));
            tvpostDate.setText(intent.getStringExtra("postDate"));
            tvpostUserId.setText(intent.getStringExtra("postMb"));
            tvPostText.setText(intent.getStringExtra("postContext"));
        String files = intent.getStringExtra("musicPath");

        sbpostMedia = findViewById(R.id.sbpostMedia);

        // DB에서 가져오기
        Log.d("#######",files);
         Uri uri = Uri.parse(files);

        mediaPlayer = MediaPlayer.create(PostDatailActivity.this,uri );
        sbpostMedia.setMax(mediaPlayer.getDuration());




        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnPlay.setVisibility(view.INVISIBLE);
                btnPause.setVisibility(view.VISIBLE);
                // 음원재생


                mediaPlayer.start();




            }


        });


        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnPlay.setVisibility(view.VISIBLE);
                btnPause.setVisibility(view.INVISIBLE);
                // 음원 중지


                mediaPlayer.pause();




            }
        });

        findViewById(R.id.btnfinish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if(mediaPlayer.isPlaying()){
                    sbpostMedia.setProgress(mediaPlayer.getCurrentPosition());

                }

            }
        },0,100);



    }
}