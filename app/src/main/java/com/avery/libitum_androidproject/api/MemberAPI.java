package com.avery.libitum_androidproject.api;

import com.avery.libitum_androidproject.userdata.Member;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MemberAPI {



    @POST("member")
    Call<Void> regist(@Body Member param);

    @POST("Login")
    Call<Void> login(@Body Member param);



}
