package com.avery.libitum_androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.avery.libitum_androidproject.connectionAPI.MyDB;
import com.avery.libitum_androidproject.support.PermissionSupport;

public class introActivity extends AppCompatActivity {
       EditText etUserId,etUserPw;

       private PermissionSupport permission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        etUserId = findViewById(R.id.etUserId);
        etUserPw = findViewById(R.id.etUserPw);

//        if(checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED){
//            requestPermissions(new String[]{Manifest.permission.CAMERA}, 111);
//
//        }
//
//        // storage permission
//
//            if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//                if(shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
//                    Toast.makeText(this, "외부 저장소 사용을 위해 읽기/쓰기 필요", Toast.LENGTH_SHORT).show();
//                }
//
//                requestPermissions(new String[]
//                        {Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE}, 2);
//            }
        permissionCheck();


      //  myDB.loginFlag=false;

        findViewById(R.id.btnActionInsertUser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 로그인 실패시 화면 유지
                MyDB myDB = new MyDB(introActivity.this);
                String id = etUserId.getText().toString();
                String pw = etUserPw.getText().toString();


                myDB.login(id,pw);
//                //로그인 성공시
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        if(myDB.loginFlag == true) {
//                            Intent intent = new Intent(introActivity.this, MainActivity.class);
//                            Toast.makeText(introActivity.this, "로그인 성공",Toast.LENGTH_SHORT).show();
//                            startActivity(intent);
//                            finish();
//                        }else{
//                            Toast.makeText(introActivity.this, "로그인 실패",Toast.LENGTH_SHORT).show();
//                        }
//
//                    }
//                },350);


            }
        });



        findViewById(R.id.btnLoginGo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(introActivity.this,InsertUserActivity.class);
                startActivity(intent);
            }
        });





    }



    private  void permissionCheck(){


        if(Build.VERSION.SDK_INT >= 23){

            permission = new PermissionSupport(this,this);


            if(!permission.checkPermission()){
                permission.requestPermission();
            }

        }

    }



}