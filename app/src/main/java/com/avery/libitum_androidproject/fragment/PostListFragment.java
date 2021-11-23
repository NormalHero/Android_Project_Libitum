package com.avery.libitum_androidproject.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.avery.libitum_androidproject.DBSQLite.MyDB;
import com.avery.libitum_androidproject.MainActivity;
import com.avery.libitum_androidproject.R;
import com.avery.libitum_androidproject.adapter.MemberRecycleAdapter;
import com.avery.libitum_androidproject.api.APIClient;
import com.avery.libitum_androidproject.api.PostAPI;
import com.avery.libitum_androidproject.postdata.LibitumPost;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PostListFragment extends Fragment {
    MainActivity activity;
    Retrofit retrofit = APIClient.getClient();
    MemberRecycleAdapter memberRecycleAdapter;
    PostAPI postAPI = retrofit.create(PostAPI.class);




    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity =(MainActivity)getActivity();

    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }

    public PostListFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post_list, container, false);
        RecyclerView rvPostList = view.findViewById(R.id.rvPostList);
        MyDB myDB = new MyDB();



        memberRecycleAdapter = new MemberRecycleAdapter(getContext());
        rvPostList.setAdapter(memberRecycleAdapter);
        LinearLayoutManager lManager = new LinearLayoutManager(getContext());
        rvPostList.setLayoutManager(lManager);
        getPostList();


        //myDB.getPostList();


        Button btnTest = (Button)view.findViewById(R.id.btnTest);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onFragmentChange(3);


            }
        });
        return view;
    }




    public void getPostList(){

        postAPI.getPostList(4).enqueue(new Callback<List<LibitumPost>>() {
            @Override
            public void onResponse(Call<List<LibitumPost>> call, Response<List<LibitumPost>> response) {
                if(response.code() == 200){
                    List<LibitumPost> list = response.body();

                    for (int i = 0; i < list.size(); i++){

                        Log.d("### Member List ###", i+" : "+ list.get(i));
                        Log.d("#### Member #### ",i + " : " +list.get(i).getTitle() + " : " +list.get(i).getMemberName());


                        memberRecycleAdapter.addItem(new LibitumPost(list.get(i).getTitle(), list.get(i).getMemberName()));

                    }
                }
            }

            @Override
            public void onFailure(Call<List<LibitumPost>> call, Throwable t) {

            }
        });

    }
}