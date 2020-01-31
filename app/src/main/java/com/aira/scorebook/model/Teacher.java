package com.aira.scorebook.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Teacher {



    @SerializedName("id")
    @Expose(serialize = false)
    private int id;
    @SerializedName("userName")
    private String mUserName;
    @SerializedName("password")
    private String mPassword;
    @SerializedName("firstName")
    @Expose
    private String mName;
    @SerializedName("lastName")
    @Expose
    private String mLastName;
    @SerializedName("teacher_code")
    @Expose
    private int mTeacherCode;

    public Teacher(String userName,String password,String mName,
                   String mLastName, int mTeacherCode) {
        this.mUserName=userName;
        this.mPassword=password;
        this.mName = mName;
        this.mLastName = mLastName;
        this.mTeacherCode = mTeacherCode;
    }


    public int getId() {
        return id;
    }

    public String getUserName() {
        return mUserName;
    }

    public String getPassword() {
        return mPassword;
    }

    public String getName() {
        return mName;
    }

    public String getLastName() {
        return mLastName;
    }

    public int getTeacherCode() {
        return mTeacherCode;
    }








}
