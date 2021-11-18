package com.avery.libitum_androidproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.avery.libitum_androidproject.fragment.InsertPostFragment;
import com.avery.libitum_androidproject.fragment.MyFeedFragment;
import com.avery.libitum_androidproject.fragment.PostDetailFragment;
import com.avery.libitum_androidproject.fragment.PostListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavi;
    Toolbar toolbar;
    int selectedFragment = 0;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    InsertPostFragment insertPostFragment;
    PostDetailFragment postDetailFragment;
    PostListFragment postListFragment;
    MyFeedFragment myFeedFragment;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        getSupportActionBar().setIcon(R.drawable.logo);



        insertPostFragment = new InsertPostFragment();
        postDetailFragment = new PostDetailFragment();
        postListFragment = new PostListFragment();
        myFeedFragment = new MyFeedFragment();


        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fl_main,postListFragment);
        fragmentTransaction.commit();

        bottomNavi = findViewById(R.id.bottomNavi);
        bottomNavi.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

             if(item.getItemId() == R.id.mi_postList){

                 if(selectedFragment != 0){
                     fragmentTransaction = fragmentManager.beginTransaction();
                     fragmentTransaction.replace(R.id.fl_main, postListFragment);
                     fragmentTransaction.commit();
                     selectedFragment = 0;
                     return true;
                 }


             }else if(item.getItemId() == R.id.mi_insertPost){
                 fragmentTransaction = fragmentManager.beginTransaction();
                 fragmentTransaction.replace(R.id.fl_main,insertPostFragment);
                 fragmentTransaction.commit();
                 selectedFragment = 1;
                 return true;

             }else if(item.getItemId() == R.id.mi_myFeed){
                 fragmentTransaction = fragmentManager.beginTransaction();
                 fragmentTransaction.replace(R.id.fl_main, myFeedFragment);
                 fragmentTransaction.commit();
                 selectedFragment = 2;
                 return true;
             }














                return false;
            }
        });










    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.tm_logOut){
            Intent intent = new Intent(this, introActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    public void onFragmentChange(int index){
        if(index == 0){
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_main,postListFragment).commit();
        }else if(index == 3){
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_main,postDetailFragment).commit();
        }
    }



}