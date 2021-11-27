package com.avery.libitum_androidproject.fragment;

import static com.avery.libitum_androidproject.connectionAPI.MyDB.loginUserName;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.avery.libitum_androidproject.InsertUserActivity;
import com.avery.libitum_androidproject.MyProfileEditActivity;
import com.avery.libitum_androidproject.R;
import com.avery.libitum_androidproject.adapter.LoginMemberPostAdapter;
import com.avery.libitum_androidproject.api.APIClient;
import com.avery.libitum_androidproject.api.MemberAPI;
import com.avery.libitum_androidproject.api.PostAPI;
import com.avery.libitum_androidproject.connectionAPI.MyDB;
import com.avery.libitum_androidproject.memberholder.LoginMemberHolder;
import com.avery.libitum_androidproject.postdata.LibitumPost;
import com.avery.libitum_androidproject.userdata.Member;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MyFeedFragment extends Fragment {
   ImageView ivUserImg;
    TextView tvUserText, tvUserId;
    LoginMemberHolder loginMemberHolder;
    Retrofit retrofit = APIClient.getClient();
    MemberAPI memberAPI = retrofit.create(MemberAPI.class);
    PostAPI postAPI = retrofit.create(PostAPI.class);
    LoginMemberPostAdapter loginMemberPostAdapter;

    Uri uri;
    public MyFeedFragment() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_feed, container, false);
        getUser();

        ImageButton btnProfileSetting = view.findViewById(R.id.btnProfileSetting);
        ivUserImg=view.findViewById(R.id.ivUserImg);
        tvUserId= view.findViewById(R.id.tvUserId);
        tvUserText = view.findViewById(R.id.tvUserText);
        RecyclerView rvLoginPostList = view.findViewById(R.id.rvLoginPostList);

        loginMemberPostAdapter = new LoginMemberPostAdapter(getContext());
        rvLoginPostList.setAdapter(loginMemberPostAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        rvLoginPostList.setLayoutManager(gridLayoutManager);
        // 그리드
        // 메소드 호출
        getLoginPostList();


//       tvUserId.setText(loginMemberHolder.getTvUserText());
//        tvUserText.setText(loginMemberHolder.getTvUserText());

        btnProfileSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getActivity(), MyProfileEditActivity.class);
                startActivity(intent);


            }
        });


        return view;


    }


    public void getUser (){


        memberAPI.getUser(4).enqueue(new Callback<List<Member>>() {
            @Override
            public void onResponse(Call<List<Member>> call, Response<List<Member>> response) {
                LoginMemberHolder loginMemberHolder ;
                List<Member> list = response.body();

                for (int i = 0; i < list.size(); i++){


                    Log.d("#### Member #### ",i + " : " +list.get(i).getLoginId() );
                    if(list.get(i).getLoginId().equals(loginUserName)){
                        Log.d("!!!!!!",list.get(i).getLoginId());


//                        loginMemberHolder = new LoginMemberHolder(list.get(i).getLoginId(),list.get(i).getData1(),list.get(i).getData2());
//                        loginMemberHolder.setTvUserId(list.get(i).getLoginId());
//                        loginMemberHolder.setTvUserText(list.get(i).getData1());
//                        loginMemberHolder.setIvUserImg(list.get(i).getData2());


                        tvUserId.setText(list.get(i).getLoginId());
                        tvUserText.setText(list.get(i).getData1());

                        if (list.get(i).getData2() == null ) {
//                            uri = Uri.parse("storage/emulated/0/Download/defaultProfile.png");
                            ivUserImg.setImageResource(R.drawable.profile);
                        }else {
                            uri = Uri.parse(list.get(i).getData2());
                            ivUserImg.setImageURI(uri);
                        }





                    }
                }




            }

            @Override
            public void onFailure(Call<List<Member>> call, Throwable t) {

            }



        });

    }

    public void getLoginPostList(){

        postAPI.getPostList(4).enqueue(new Callback<List<LibitumPost>>() {
            @Override
            public void onResponse(Call<List<LibitumPost>> call, Response<List<LibitumPost>> response) {
                if(response.code() == 200){
                    List<LibitumPost> list = response.body();

                    for (int i = 0; i < list.size(); i++){



                        if(list.get(i).getMemberName().equals(loginUserName)){
                            Log.d("!!!!!!",list.get(i).getMemberName());


                            Log.d("### Member List ###", i+" : "+ list.get(i));
                            Log.d("#### Member #### ",i + " : " +list.get(i).getTitle() + " : " +list.get(i).getMemberName());


                            loginMemberPostAdapter.addItem(new LibitumPost(list.get(i).getTitle(), list.get(i).getMemberName(),
                                    list.get(i).getContent() , list.get(i).getData1(),list.get(i).getCreateAt()));





                        }






                    }
                }
            }

            @Override
            public void onFailure(Call<List<LibitumPost>> call, Throwable t) {

            }
        });

    }


}