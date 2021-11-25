package com.avery.libitum_androidproject.dialog;



import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.FileProvider;

import com.avery.libitum_androidproject.InsertUserActivity;
import com.avery.libitum_androidproject.R;

import java.io.File;
import java.io.IOException;


/*
직접 커스텀한 다이얼로그들을 띄워주고 다이얼로그 안에서의 동작을 정의하는 클래스 (싱글톤)
 */
public class CustomDialog extends Dialog {

    private static CustomDialog customDialog;

    Context context;





//    private CustomDialog(@NonNull Context context) {
//        super(context);
//    }

//    public static CustomDialog getInstance(Context context) {
//        customDialog = new CustomDialog(context);
//        boolean isCamera = false;
//
//        return customDialog;
//    }


    private CustomDialog(@NonNull Activity activity) {

        super(activity);
        this.context = activity;

    }

    public static CustomDialog getInstance(Activity activity) {
        customDialog = new CustomDialog(activity);


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
//                isCamera = false;
//
//                Intent intent = new Intent();
//                intent.setType("image/*");
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                resultLauncher.launch(intent);

//                startActivityForResult(intent, 1234);


//                Toast.makeText(getContext(),"구현중인 기능입니다! (앨범)",Toast.LENGTH_SHORT).show();
                dismiss();

               ((InsertUserActivity)context).galleryAction();


            }
        });


        TextView tvGetCamera = findViewById(R.id.tvGetCamera);
        tvGetCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 카메라에서 가져오는 코드 구현

                ((InsertUserActivity)context).cameraAction();


//                Toast.makeText(getContext(),"구현중인 기능입니다! (카메라)",Toast.LENGTH_SHORT).show();
            }
        });





//       ImageView ivInsertUserImg  = findViewById(R.id.ivInsertUserImg);
//        resultLauncher = activity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
//                new ActivityResultCallback<ActivityResult>() {
//                    @Override
//                    public void onActivityResult(ActivityResult result) {
//
//                        if(result.getResultCode() == activity.RESULT_OK){
//                            if(isCamera == false) {
//
//                                Uri uri = result.getData().getData();
//                                ivInsertUserImg.setImageURI(uri);
//                            }else{
//
//                                ivInsertUserImg.setImageURI(photoUri);
//
//                            }
//                        }
//                    }
//                });
        customDialog.show();

    }






}

