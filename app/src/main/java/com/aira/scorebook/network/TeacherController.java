package com.aira.scorebook.network;

import com.aira.scorebook.model.Teacher;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TeacherController implements Callback<Teacher> {

    static final String BASE_URL = "http://192.168.43.77/";

    public void start(Teacher teacher) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(100, TimeUnit.SECONDS)
                .connectTimeout(100, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();

        GerritAPI gerritAPI = retrofit.create(GerritAPI.class);

        String firstName = teacher.mName;
        String lasrName = teacher.mLastName;
        int teacher_code = teacher.mTeacherCode;
        Call<Teacher> call = gerritAPI.registerTeacher(firstName,lasrName,teacher_code);
        call.enqueue(this);

    }


    @Override
    public void onResponse(Call<Teacher> call, Response<Teacher> response) {

        if (response.isSuccessful()) {
            long id = response.body().getId();
        }
    }

    @Override
    public void onFailure(Call<Teacher> call, Throwable t) {
        t.printStackTrace();

    }


}
