package com.avery.libitum_androidproject.DBSQLite;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.avery.libitum_androidproject.MainActivity;
import com.avery.libitum_androidproject.adapter.MemberRecycleAdapter;
import com.avery.libitum_androidproject.api.APIClient;
import com.avery.libitum_androidproject.api.MemberAPI;
import com.avery.libitum_androidproject.api.PostAPI;
import com.avery.libitum_androidproject.introActivity;
import com.avery.libitum_androidproject.postdata.LibitumPost;
import com.avery.libitum_androidproject.userdata.Member;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MyDB {
    Retrofit retrofit = APIClient.getClient();
    MemberAPI memberAPI = retrofit.create(MemberAPI.class);
    PostAPI postAPI = retrofit.create(PostAPI.class);
    Activity activity;
    MemberRecycleAdapter memberRecycleAdapter;
   public static String loginUserName ="";

//    public static boolean loginFlag = false;

    public MyDB(Activity activity) {
        this.activity = activity;
    }

    public MyDB() {

    }

    public  void regist(String loginid, String setpassword, String data1 ){




        Member member = new Member();
        member.setLoginId(loginid);
        member.setPassword(setpassword);
        member.setData1(data1);
        member.setType(4);


        memberAPI.regist(member).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.code()==200){

                    Toast.makeText(activity, "회원가입 성공",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(activity, introActivity.class);
                    activity.startActivity(intent);
                    activity.finish();
                }else{
                    Toast.makeText(activity, "회원가입 실패",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });


    }

    public void login(String loginid, String setpassword){
        Member member = new Member();
        member.setLoginId(loginid);
        member.setPassword(setpassword);
        member.setType(4);
        loginUserName = loginid;

        memberAPI.login(member).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.code() == 200){
//                    loginFlag = true;
                    //로그인 성공시
                    Intent intent = new Intent(activity, MainActivity.class);
                    Toast.makeText(activity, "로그인 성공",Toast.LENGTH_SHORT).show();
                    activity.startActivity(intent);
                    activity.finish();



                }else{
//                    loginFlag = false;
                    Toast.makeText(activity, "로그인 실패",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(activity, "통신 오류",Toast.LENGTH_SHORT).show();
            }
        });


    }




    public void insertPost(String title, String content, String data1, String memberName){
        LibitumPost libitumPost = new LibitumPost();
        libitumPost.setTitle(title);
        libitumPost.setContent(content);
        libitumPost.setData1(data1);
        libitumPost.setMemberName(memberName);
        libitumPost.setType(4);

        postAPI.insertPost(libitumPost).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.code() == 200){
                    // 다른 프래그먼트 이동 or 성공 메시지만
                    Toast.makeText(activity, "게시물을 등록하였습니다 !",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(activity, "게시물을 등록 실패 !",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
//    public void getPostList(){
//
//        postAPI.getPostList(4).enqueue(new Callback<List<LibitumPost>>() {
//            @Override
//            public void onResponse(Call<List<LibitumPost>> call, Response<List<LibitumPost>> response) {
//                if(response.code() == 200){
//                    List<LibitumPost> list = response.body();
//
//                    for (int i = 0; i < list.size(); i++){
//
//                        Log.d("### Member List ###", i+" : "+ list.get(i));
//                      Log.d("#### Member #### ",i + " : " +list.get(i).getTitle() + " : " +list.get(i).getMemberName());
//
//
//                        memberRecycleAdapter.addItem(new LibitumPost(list.get(i).getTitle(), list.get(i).getMemberName()));
//
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<LibitumPost>> call, Throwable t) {
//
//            }
//        });
//
//    }




}
