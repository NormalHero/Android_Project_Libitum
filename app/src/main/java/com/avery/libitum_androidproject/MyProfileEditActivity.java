package com.avery.libitum_androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.avery.libitum_androidproject.dialog.CustomDialog;

public class MyProfileEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile_edit);


        findViewById(R.id.btnUpdateUserImg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        findViewById(R.id.btnActionProUpdate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // DB 프로필 업데이트 구현
            }
        });
        findViewById(R.id.btnNotProUpdate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        findViewById(R.id.btnUpdateUserImg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog.getInstance(MyProfileEditActivity.this).showDefaultDialog();
            }
        });
        findViewById(R.id.btnActionProUpdate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 업데이트할 입력값 DB 업데이트
                Toast.makeText(MyProfileEditActivity.this,"구현중인 기능입니다! (프로필 업데이트)",Toast.LENGTH_SHORT).show();
            }
        });


    }
}