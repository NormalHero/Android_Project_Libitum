package com.avery.libitum_androidproject.memberholder;

public class LoginMemberHolder {

   private String ivUserImg;
    private String tvUserText;
    private  String tvUserId;

    public  LoginMemberHolder() {
    }

    public LoginMemberHolder(String ivUserImg, String tvUserText, String tvUserId) {
        this.ivUserImg = ivUserImg;
        this.tvUserText = tvUserText;
        this.tvUserId = tvUserId;
    }


    public  String getIvUserImg() {
        return ivUserImg;
    }

    public void setIvUserImg(String ivUserImg) {
        this.ivUserImg = ivUserImg;
    }

    public  String getTvUserText() {
        return tvUserText;
    }

    public  void setTvUserText(String tvUserText) {
        this.tvUserText = tvUserText;
    }

    public  String getTvUserId() {
        return tvUserId;
    }

    public void setTvUserId(String tvUserId) {
        this.tvUserId = tvUserId;
    }
}
