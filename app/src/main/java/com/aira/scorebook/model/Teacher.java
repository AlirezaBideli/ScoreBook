package com.aira.scorebook.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Teacher {


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @SerializedName("id")
    @Expose(serialize = false)
    public int id;
    @SerializedName("firstName")
    @Expose
    public String mName;
    @SerializedName("lastName")
    @Expose
    public String mLastName;
    @SerializedName("teacher_code")
    @Expose
    public int mTeacherCode;

    public Teacher(String mName, String mLastName, int mTeacherCode) {
        this.mName = mName;
        this.mLastName = mLastName;
        this.mTeacherCode = mTeacherCode;
    }



    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public int getmTeacherCode() {
        return mTeacherCode;
    }

    public void setmTeacherCode(int mTeacherCode) {
        this.mTeacherCode = mTeacherCode;
    }




}
