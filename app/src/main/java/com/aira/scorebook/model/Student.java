package com.aira.scorebook.model;

import org.greenrobot.greendao.annotation.ToMany;

public class Student {


    private long Id;
    private String mName;
    private String mLastName;
    private String nStudentNumber;

    private long mTeacherId;
    @ToMany(referencedJoinProperty = "mTeacherId")
    private Teacher mTeacher;

    private long mClassId;

    public Student() {
    }
}
