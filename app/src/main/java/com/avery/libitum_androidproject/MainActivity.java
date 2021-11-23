package com.avery.libitum_androidproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

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
    private final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STROAGE = 1001;
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



// storage permission
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                    || checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                if(shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    Toast.makeText(this, "외부 저장소 사용을 위해 읽기/쓰기 필요", Toast.LENGTH_SHORT).show();
                }

                requestPermissions(new String[]
                        {Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE}, 2);
            }
        }



        if(checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                || checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){

            String[] permission ={Manifest.permission.CAMERA, Manifest.permission.READ_CONTACTS};
            requestPermissions(permission, 1004); // 1004 리퀘스트 코드





        }

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
            finish();

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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == 1004){
            if(grantResults.length > 0){

                if(grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(MainActivity.this, " 권한 획득 성공 !! ", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, " 권한 획득 실패 !! ", Toast.LENGTH_SHORT).show();
                }

            }

        }


    }


}
