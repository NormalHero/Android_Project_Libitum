package com.avery.libitum_androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.avery.libitum_androidproject.DBSQLite.MyDB;

public class introActivity extends AppCompatActivity {
       EditText etUserId,etUserPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        etUserId = findViewById(R.id.etUserId);
        etUserPw = findViewById(R.id.etUserPw);

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
}