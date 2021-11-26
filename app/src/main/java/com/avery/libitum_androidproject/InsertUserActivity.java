package com.avery.libitum_androidproject;


import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.avery.libitum_androidproject.connectionAPI.MyDB;
import com.avery.libitum_androidproject.dialog.CustomDialog;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertUserActivity extends AppCompatActivity {
    EditText etUserPw,etUserId, etCkPw, etUserMessage;
    ImageView ivInsertUserImg;
    String filePath;


    ActivityResultLauncher<Intent> resultLauncher;

    String imgFilePath, data2;
    Uri photoUri;

    boolean isCamera = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_user);

        etUserPw = findViewById(R.id.etUserPw);
        etUserId = findViewById(R.id.etUserId);
        etUserMessage = findViewById(R.id.etUserMessage);
        etCkPw = findViewById(R.id.etCkPw);
        ivInsertUserImg= findViewById(R.id.ivInsertUserImg);



        findViewById(R.id.btnActionInsertUser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // DB에 회원정보 연결하기
               // tUserPw != null && etUserId != null && etUserMessage



                if(!etUserPw.getText().toString().equals(etCkPw.getText().toString())  ){
                    Toast.makeText(InsertUserActivity.this, "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show();
                    etCkPw.requestFocus();



                }else if(etUserPw.getText().toString().equals("")){
                    Toast.makeText(InsertUserActivity.this, "비밀번호를 입력 해주세요!", Toast.LENGTH_SHORT).show();
                    etUserPw.requestFocus();
                }else if (etUserId.getText().toString().equals("")){
                    Toast.makeText(InsertUserActivity.this, "아이디를 입력 해주세요!", Toast.LENGTH_SHORT).show();
                    etUserId.requestFocus();
                }else if(etUserMessage.getText().toString().equals("")){
                    Toast.makeText(InsertUserActivity.this, "소개글을 입력하세요!", Toast.LENGTH_SHORT).show();
                    etUserMessage.requestFocus();
                }else{
                    MyDB myDB = new MyDB(InsertUserActivity.this);
                    String id = etUserId.getText().toString();
                    String pw = etUserPw.getText().toString();
                    String data1 = etUserMessage.getText().toString();
//                Log.d("&&&",photoUri.getPath());

                    if(photoUri == null ){
                        data2 = filePath;
                    }else if(filePath == null){
                        data2 = photoUri.getPath();
                    }

                    myDB.regist(id, pw,data1, data2);
                }

            }
        });

        findViewById(R.id.btnLoginGo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InsertUserActivity.this, introActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btnUserImg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




   CustomDialog.getInstance(InsertUserActivity.this).showDefaultDialog();





                    isCamera = false;
//
//                    Intent intent = new Intent();
//                    intent.setType("image/*");
//                    intent.setAction(Intent.ACTION_GET_CONTENT);
//
//
//
//                    resultLauncher.launch(intent);
//









            }
        });

        resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {

                        if(result.getResultCode() == RESULT_OK){
                            if(isCamera == false) {

                                Uri uri = result.getData().getData();
                                ivInsertUserImg.setImageURI(uri);

                                filePath = result.getData().getData().getPath();
                                filePath =  filePath.substring(15);


                            }else{

                                ivInsertUserImg.setImageURI(photoUri);

                            }
//                            Log.d("####test####",filePath);
                        }
                    }
                });



    }

    File createImageFile() throws IOException{



        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

//        SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
//        String timeStamp = date.format(new Date());
        String imageFileName = "TEST_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFileName, ".jpg", storageDir);

        imgFilePath = image.getAbsolutePath();

        return image;
    }


public void galleryAction(){

//    Toast.makeText(InsertUserActivity.this,"구현중인 기능입니다!!!!!! (카메라)",Toast.LENGTH_SHORT).show();
    isCamera = false;

    Intent intent = new Intent();
    intent.setType("image/*");
    intent.setAction(Intent.ACTION_GET_CONTENT);

//                startActivityForResult(intent, 1234);

    resultLauncher.launch(intent);


}


    public void cameraAction(){
        isCamera = true;

        Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);

        File photoFile = null;

        try{

            photoFile = createImageFile();

        }catch(IOException e){

        }

        if(photoFile != null){

            photoUri = FileProvider.getUriForFile(InsertUserActivity.this, getPackageName(), photoFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);

        }

        resultLauncher.launch(intent);
    }




}