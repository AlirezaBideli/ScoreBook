package com.aira.scorebook.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Student {

    @Expose(serialize = false)
    private long mId;
    @SerializedName("first_name")
    private String mName;
    @SerializedName("last_name")
    private String mLastName;
    @SerializedName("student_code")
    private int mStudentCode;
    @SerializedName("teacher_id")
    private long mTeacherId;

    public Student(String name, String lastName, int studentCode,long teacherId) {
        mName = name;
        mLastName = lastName;
        mStudentCode = studentCode;
        this.mTeacherId=teacherId;
    }


    public long getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getLastName() {
        return mLastName;
    }

    public int getStudentCode() {
        return mStudentCode;
    }

    public long getTeacherId()
    {
        return mTeacherId;
    }
}
