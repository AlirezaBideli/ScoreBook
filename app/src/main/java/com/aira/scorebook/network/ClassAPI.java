package com.aira.scorebook.network;

import com.aira.scorebook.model.ClassT;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ClassAPI {
    @GET("insertClass.php")
    Call<ClassT> addClass(@Query("name")String name,
                          @Query("time")String time,
                          @Query("day_code")int dayCode,
                          @Query("presentation_code")int classCode,
                          @Query("teacher_id")long teacherId);
}
