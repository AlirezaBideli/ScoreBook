package com.aira.scorebook.network;

import com.aira.scorebook.model.Teacher;
import com.aira.scorebook.tools.MySharedPreferences;
import com.aira.scorebook.tools.SharedKeys;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TeacherController implements Callback<Teacher> {


    public void start(Teacher teacher) {

        Retrofit retrofit = RetrofitInstance.getInstance();
        TeacherAPI gerritAPI = retrofit.create(TeacherAPI.class);

        String userName=teacher.getUserName();
        String password=teacher.getPassword();
        String firstName = teacher.getName();
        String lastName = teacher.getLastName();
        int teacher_code = teacher.getTeacherCode();

        Call<Teacher> call = gerritAPI.registerTeacher(userName,password,firstName,
                lastName, teacher_code);
        call.enqueue(this);
    }


    @Override
    public void onResponse(Call<Teacher> call, Response<Teacher> response) {

        if (response.isSuccessful()) {
            long id = response.body().getId();
            String firstName=response.body().getName();
            String lastName=response.body().getLastName();
            String teacher_code=response.body().getTeacherCode()+"";
            String userName=response.body().getUserName();

            MySharedPreferences sharedPreferences=MySharedPreferences.getInstance();
            sharedPreferences.storeData(SharedKeys.TEACHER_ID,id+"");
            sharedPreferences.storeData(SharedKeys.FIRST_NAME,firstName);
            sharedPreferences.storeData(SharedKeys.LAST_NAME,lastName);
            sharedPreferences.storeData(SharedKeys.TEACHER_CODE,teacher_code);
            sharedPreferences.storeData(SharedKeys.USERNAME,userName);
        }
    }

    @Override
    public void onFailure(Call<Teacher> call, Throwable t) {
        t.printStackTrace();
    }


}
