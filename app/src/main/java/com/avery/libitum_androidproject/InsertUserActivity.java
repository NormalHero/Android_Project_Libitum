package com.avery.libitum_androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InsertUserActivity extends AppCompatActivity {
    EditText etUserPw,etUserId, etCkPw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_user);

        etUserPw = findViewById(R.id.etUserPw);
        etUserId = findViewById(R.id.etUserId);
        etCkPw = findViewById(R.id.etCkPw);


        findViewById(R.id.btnActionInsertUser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // DB에 회원정보 연결하기
                // etUserId, etCkPw가 서로 일치 하지 않다면, 또는 null값 이라면 버튼 비활성화
            }
        });

        findViewById(R.id.btnLoginGo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InsertUserActivity.this, introActivity.class);
                startActivity(intent);
            }
        });
    }
}