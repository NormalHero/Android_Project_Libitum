package com.avery.libitum_androidproject.support;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class PermissionSupport {

    private Context context;
    private Activity activity;

    private String[] permissions = {
            Manifest.permission.CAMERA,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.WRITE_EXTERNAL_STORAGE

    };

    private List permissionList;

    private final int MUTIPLE_PERMISSIONS = 7777;


    public PermissionSupport(Activity mactivity, Context mcontext){
        this.activity = mactivity;
        this.context = mcontext;

    }

    public  boolean checkPermission(){
        int result;
        permissionList = new ArrayList<String>();


        for(String pm : permissions){
            result = ContextCompat.checkSelfPermission(context, pm);
            if (result != PackageManager.PERMISSION_GRANTED){
                permissionList.add(pm);
            }
        }
        if(!permissionList.isEmpty()){
            return false;
        }
        return true;
    }

    public void requestPermission(){
        ActivityCompat.requestPermissions(activity, (String[]) permissionList.toArray(new String
                [permissionList.size()]), MUTIPLE_PERMISSIONS);
    }

    public boolean permissionResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){


        if(requestCode == MUTIPLE_PERMISSIONS && (grantResults.length > 0)){
            for(int i = 0; i < grantResults.length ; i++){
                if(grantResults[i] == -1){
                    return false;
                }
            }
        }

        return true;
    }



}
