package com.aira.scorebook.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;


@Entity
public class Teacher extends DbEntity {

    @Id(autoincrement = true)
    private long id;

    @Property(nameInDb = "firstName")
    private  String mName;
    @Property(nameInDb = "lastName")
    private String mLastName;

    public Teacher(String name, String lastName, int teacherCode) {
        this.mName = name;
        this.mLastName = lastName;
        this.mTeacherCode = teacherCode;
    }

    @Property(nameInDb = "teacherCode")
    private int mTeacherCode;

    @Generated(hash = 2064733251)
    public Teacher(long id, String mName, String mLastName, int mTeacherCode) {
        this.id = id;
        this.mName = mName;
        this.mLastName = mLastName;
        this.mTeacherCode = mTeacherCode;
    }

    @Generated(hash = 1630413260)
    public Teacher() {
    }


    public long getId() {
        return this.id;
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


    public void setId(long id) {
        this.id = id;
    }


    public String getMName() {
        return this.mName;
    }


    public void setMName(String mName) {
        this.mName = mName;
    }


    public String getMLastName() {
        return this.mLastName;
    }


    public void setMLastName(String mLastName) {
        this.mLastName = mLastName;
    }


    public int getMTeacherCode() {
        return this.mTeacherCode;
    }


    public void setMTeacherCode(int mTeacherCode) {
        this.mTeacherCode = mTeacherCode;
    }

}
