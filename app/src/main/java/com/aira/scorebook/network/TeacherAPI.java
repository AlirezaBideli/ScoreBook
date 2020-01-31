package com.aira.scorebook.network;


import com.aira.scorebook.model.Teacher;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TeacherAPI {

    @GET("insertTeacher.php")
    Call<Teacher> registerTeacher(@Query("user_name")String userName,
                                  @Query("password")String password,
                                  @Query("first_name")String firstName,
                                  @Query("last_name")String lastName,
                                  @Query("teacher_code") int teacher_code);
}
