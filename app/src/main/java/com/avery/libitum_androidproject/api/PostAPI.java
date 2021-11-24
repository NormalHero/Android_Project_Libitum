package com.avery.libitum_androidproject.api;

import com.avery.libitum_androidproject.postdata.LibitumPost;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface PostAPI {

    @POST("POST")
    Call<Void> insertPost(@Body LibitumPost param);
    @PUT("POST")
    Call<Void> updatePost(@Body LibitumPost param);

    @GET("POST")
    Call<List<LibitumPost>> getPostList(@Query("type")int type);

    @GET("POST")
    Call<List<LibitumPost>> getMyFeed(@Query("type")int type);

}
