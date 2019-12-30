package com.aira.scorebook.repositories;

import com.aira.scorebook.MyApplication;
import com.aira.scorebook.model.DaoSession;
import com.aira.scorebook.model.DbEntity;


public abstract class DbAction {

    protected DaoSession mDaoSession ;

    public DbAction() {
        mDaoSession= MyApplication.getInstance().getDaoSession();
    }

    public <T extends DbEntity> void insert(T entity) {
        mDaoSession.insert(entity);
    }

    public <T extends DbEntity> void delete(T entity) {
        mDaoSession.delete(entity);
    }

    public <T extends DbEntity> void update(T entity) {
        mDaoSession.update(entity);
    }

    public abstract <T extends DbEntity> T selectUnique(T entity);

}
