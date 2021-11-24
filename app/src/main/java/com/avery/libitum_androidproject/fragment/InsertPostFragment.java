package com.avery.libitum_androidproject.fragment;

import static android.content.Intent.ACTION_GET_CONTENT;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.avery.libitum_androidproject.DBSQLite.MyDB;
import com.avery.libitum_androidproject.R;


public class InsertPostFragment extends Fragment {
    EditText etpostTitle, etpostText;
    String filePath;
    ActivityResultLauncher<Intent> resultLauncher;
    Uri uri;


    public InsertPostFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_insert_post, container, false);

        ImageButton btnFindMusic = view.findViewById(R.id.btnFindMusic);
        etpostTitle = view.findViewById(R.id.etPostTitle);
        etpostText = view.findViewById(R.id.etpostText);
        btnFindMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ACTION_GET_CONTENT);
                intent.setType("audio/*");
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.setAction(ACTION_GET_CONTENT);
                resultLauncher.launch(intent);




//                startActivity(Intent.createChooser(intent, "Open"));

//                filePath = getContext().getApplicationInfo().dataDir + File.separator + System.currentTimeMillis();

//                Log.d("###",filePath);
//                File file = new File(FilePath);


//                File file = null;
//                try{
//                    file = new File(getFi);
//                }catch (FileNotFoundException e){
//                    e.printStackTrace();
//                }catch (IOException e){
//                    e.printStackTrace();
//                }





            }
        });

        resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {

            //    File fileFile =result.getData().getData().get; String getFile = fileFile.getPath()

              // /document/raw:/
                filePath= result.getData().getData().getPath();
                filePath =  filePath.substring(15);
//                filePath = Environment.getExternalStorageDirectory().getAbsolutePath(); // 절대경로를 얻는 코드


//                String file = new File(filePath).getAbsolutePath();
//                filePath = uri.getPath();
                Log.d("###",filePath );
//                Log.d("###",file);
            }
        });

        ImageButton btnActionInsertPost = view.findViewById(R.id.btnActionInsertPost);
        btnActionInsertPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                MyDB myDB = new MyDB(getActivity());

                String title = etpostTitle.getText().toString();
                String content = etpostText.getText().toString();
                String memberName= myDB.loginUserName;
                myDB.insertPost(title,content, filePath,memberName);



//        Toast.makeText(getContext(),"구현중인 기능입니다! (게시물 등록)",Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}