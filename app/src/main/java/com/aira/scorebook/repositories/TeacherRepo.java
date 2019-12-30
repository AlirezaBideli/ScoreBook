package com.aira.scorebook.repositories;


import com.aira.scorebook.model.DbEntity;
import com.aira.scorebook.model.Teacher;
import com.aira.scorebook.model.TeacherDao;


public class TeacherRepo  extends DbAction{
    private static final TeacherRepo ourInstance = new TeacherRepo();

    public static TeacherRepo getInstance() {
        return ourInstance;
    }

    @Override
    public <T extends DbEntity> T selectUnique(T entity) {

        long id=((Teacher)entity).getId();
        Teacher teacher=super.mDaoSession.queryBuilder(Teacher.class).
                where(TeacherDao.Properties.Id.eq(id))
                .unique();
        return (T) teacher;
    }
}
