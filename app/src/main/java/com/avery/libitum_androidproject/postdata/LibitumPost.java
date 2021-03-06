package com.avery.libitum_androidproject.postdata;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class LibitumPost {
    String id;
    @SerializedName("title")
    String title;
    @SerializedName("content")
    String content;
    @SerializedName("memberName")
    String memberName;
    @SerializedName("like")
    String like;
    @SerializedName("data1")
    String data1;
    @SerializedName("createdAt")
    String createdAt;
    int type ;

    public String getCreateAt() {
        return createdAt;
    }

    public void setCreateAt(String createAt) {
        this.createdAt = createAt;
    }

    public LibitumPost(){

    }
    public LibitumPost(String title, String memberName, String content, String data1, String date ) {
        this.title = title;
        this.memberName = memberName;
        this.content = content;
        this.data1 = data1;
        this.createdAt = date;

    }



    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "LibitumPost{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", memberName='" + memberName + '\'' +
                ", like='" + like + '\'' +
                ", data1='" + data1 + '\'' +
                ", createAt='" + createdAt + '\'' +
                ", type=" + type +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }
}
