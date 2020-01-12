package com.aira.scorebook.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;


@Entity
public class ClassT {

    @Id(autoincrement = true)
    private long id;
    @Property(nameInDb = "name")
    private String mName;
    @Property(nameInDb = "time")
    private String mTime;
    @Property(nameInDb = "prCode")
    private String mPrCode;

    @Property(nameInDb = "teacherId")
    private long mTeacherId;

    @Generated(hash = 623259007)
    public ClassT(long id, String mName, String mTime, String mPrCode,
            long mTeacherId) {
        this.id = id;
        this.mName = mName;
        this.mTime = mTime;
        this.mPrCode = mPrCode;
        this.mTeacherId = mTeacherId;
    }

    @Generated(hash = 1080052045)
    public ClassT() {
    }

    public long getId() {
        return this.id;
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

    public String getMTime() {
        return this.mTime;
    }

    public void setMTime(String mTime) {
        this.mTime = mTime;
    }

    public String getMPrCode() {
        return this.mPrCode;
    }

    public void setMPrCode(String mPrCode) {
        this.mPrCode = mPrCode;
    }

    public long getMTeacherId() {
        return this.mTeacherId;
    }

    public void setMTeacherId(long mTeacherId) {
        this.mTeacherId = mTeacherId;
    }

}