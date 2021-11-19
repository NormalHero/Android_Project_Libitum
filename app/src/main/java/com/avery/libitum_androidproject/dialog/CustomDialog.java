package com.avery.libitum_androidproject.dialog;


import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.avery.libitum_androidproject.R;


/*
직접 커스텀한 다이얼로그들을 띄워주고 다이얼로그 안에서의 동작을 정의하는 클래스 (싱글톤)
 */
public class CustomDialog extends Dialog {

    private static CustomDialog customDialog;

    private CustomDialog(@NonNull Context context) {
        super(context);
    }

    public static CustomDialog getInstance(Context context) {
        customDialog = new CustomDialog(context);

        return customDialog;
    }

    //다이얼로그 생성하기
    public void showDefaultDialog() {
        //참조할 다이얼로그 화면을 연결한다.
        customDialog.setContentView(R.layout.customdialog_01);

        //다이얼로그의 구성요소들이 동작할 코드작성

        TextView tvActionAlbum = customDialog.findViewById(R.id.tvActionAlbum);
        tvActionAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 앨범을 불러오는 코드 구현
                Toast.makeText(getContext(),"구현중인 기능입니다! (앨범)",Toast.LENGTH_SHORT).show();
            }
        });


        TextView tvGetCamera = findViewById(R.id.tvGetCamera);
        tvGetCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 카메라에서 가져오는 코드 구현
                Toast.makeText(getContext(),"구현중인 기능입니다! (카메라)",Toast.LENGTH_SHORT).show();
            }
        });

        customDialog.show();
    }




}

