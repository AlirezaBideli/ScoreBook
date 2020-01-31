package com.aira.scorebook.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClassT {

    @Expose(deserialize = false)
    private long id;

    @SerializedName("name")
    private String mName;
    @SerializedName("time")
    private String mTime;
    @SerializedName("day_code")
    private int mDayCode;
    @SerializedName("presentation_code")
    private int mPrCode;
    @SerializedName("teacher_id")
    private long mTeacherId;

    public ClassT(String name, String time, int dayCode, int prCode, long teacherId) {
        mName = name;
        mTime = time;
        mPrCode = prCode;
        mTeacherId = teacherId;
        this.mDayCode = dayCode;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return mName;
    }

    public String getTime() {

        return mTime;
    }

    public int getPrCode() {
        return mPrCode;
    }

    public long getTeacherId() {
        return mTeacherId;
    }


    public int getDayCode() {
        return mDayCode;
    }

}