package com.avery.libitum_androidproject.userdata;

import com.google.gson.annotations.SerializedName;

public class Member {

    String id;
    @SerializedName("loginId")
    String loginId;
    @SerializedName("password")
    String password;
    @SerializedName("name")
    String name;
    @SerializedName("data1")
    String data1;
    @SerializedName("type")
    int type ;

    public Member(){

    }

    public Member(String loginId, String name){
        this.id = loginId;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", loginId='" + loginId + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", data1='" + data1 + '\'' +
                ", type=" + type +
                '}';
    }
}
