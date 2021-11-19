package com.avery.libitum_androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class introActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);



        findViewById(R.id.btnActionInsertUser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 로그인 실패시 화면 유지


                //로그인 성공시
                Intent intent = new Intent(introActivity.this, MainActivity.class);
                startActivity(intent);
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