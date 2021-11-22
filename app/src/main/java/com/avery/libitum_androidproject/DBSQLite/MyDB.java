package com.avery.libitum_androidproject.DBSQLite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.avery.libitum_androidproject.MainActivity;
import com.avery.libitum_androidproject.api.APIClient;
import com.avery.libitum_androidproject.api.MemberAPI;
import com.avery.libitum_androidproject.helper.MyDBHelper;
import com.avery.libitum_androidproject.introActivity;
import com.avery.libitum_androidproject.userdata.Member;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MyDB {
    Retrofit retrofit = APIClient.getClient();
    MemberAPI memberAPI = retrofit.create(MemberAPI.class);
    Activity activity;

//    public static boolean loginFlag = false;

    public MyDB(Activity activity) {
        this.activity = activity;
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




}
