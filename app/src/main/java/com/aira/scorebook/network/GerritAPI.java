package com.aira.scorebook.network;


import com.aira.scorebook.model.Teacher;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GerritAPI {

    @GET("insertTeacher.php")
    Call<Teacher> registerTeacher(@Query("firstName")String firstName,
                                  @Query("lastName")String lastName,
                                  @Query("teacher_code") int teacher_code);
}
