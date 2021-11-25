//package com.avery.libitum_androidproject.fragment;
//
//import android.media.MediaPlayer;
//import android.net.Uri;
//import android.os.Bundle;
//
//import androidx.fragment.app.Fragment;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageButton;
//import android.widget.SeekBar;
//import android.widget.TextView;
//
//import com.avery.libitum_androidproject.R;
//
//import java.util.Timer;
//import java.util.TimerTask;
//
//
//public class PostDetailFragment extends Fragment {
//
//TextView tvpostTitle, tvpostDate, tvpostUserId, tvPostText;
//SeekBar sbpostMedia;
//ImageButton btnPlay, btnPause;
//MediaPlayer mediaPlayer;
//
//    public PostDetailFragment() {
//        // Required empty public constructor
//
//    }
//
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_post_detail, container, false);
//        btnPlay =(ImageButton)view.findViewById(R.id.btnPlay);
//        btnPause =(ImageButton)view.findViewById(R.id.btnPause);
//
//
////        String files ="/storage/emulated/0/Download/1.wav";
//        String files ="" ;
//        tvpostTitle= view.findViewById(R.id.etPostTitle);
//        tvpostDate= view.findViewById(R.id.tvpostDate);
//        tvpostUserId= view.findViewById(R.id.tvpostUserId);
//        tvPostText= view.findViewById(R.id.tvPostText);
//        if(getArguments() == null){
//            tvpostTitle.setText(getArguments().getString("postTitle"));
//            tvpostDate.setText(getArguments().getString("postDate"));
//            tvpostUserId.setText(getArguments().getString("postMb"));
//            tvPostText.setText(getArguments().getString("postContext"));
//            files = getArguments().getString("musicPath");
//        }
//      sbpostMedia = view.findViewById(R.id.sbpostMedia);
//
//        // DB에서 가져오기
//
//        Uri uri = Uri.parse(files);
//
//        mediaPlayer = MediaPlayer.create(getActivity(),uri );
//        sbpostMedia.setMax(mediaPlayer.getDuration());
//
//
//
//
//        btnPlay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                btnPlay.setVisibility(view.INVISIBLE);
//                btnPause.setVisibility(view.VISIBLE);
//                // 음원재생
//
//
//                mediaPlayer.start();
//
//
//
//
//                }
//
//
//        });
//
//
//        btnPause.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                btnPlay.setVisibility(view.VISIBLE);
//                btnPause.setVisibility(view.INVISIBLE);
//                // 음원 중지
//
//
//                        mediaPlayer.pause();
//
//
//
//
//            }
//        });
//
//
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
//
//
//        return view;
//    }
//
//
//
//
//}