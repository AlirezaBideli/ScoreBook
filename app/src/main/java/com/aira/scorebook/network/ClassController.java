package com.aira.scorebook.network;

import com.aira.scorebook.model.ClassT;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ClassController implements Callback<ClassT> {


    public void start(ClassT classT) {

        Retrofit retrofit = RetrofitInstance.getInstance();
        ClassAPI postApi = retrofit.create(ClassAPI.class);
        String name=classT.getName();
        int presentation_code=classT.getPrCode();
        long teacherId=classT.getTeacherId();
        String time=classT.getTime();
        int dayCode=classT.getDayCode();

        Call<ClassT> call=postApi.addClass(name,time,dayCode,presentation_code,teacherId);
        call.enqueue(this);


    }


    @Override
    public void onResponse(Call<ClassT> call, Response<ClassT> response) {

        if (response.isSuccessful()) {
            long id = response.body().getId();
        }
    }

    @Override
    public void onFailure(Call<ClassT> call, Throwable t) {

        t.printStackTrace();

    }



}
