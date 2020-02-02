package com.aira.scorebook.network;


import com.aira.scorebook.model.Student;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface StudentAPI {

    @GET("insertStudent.php")
    Call<Student> addStudent(@Query("first_name") String firstName,
                             @Query("last_name") String lastName,
                             @Query("student_code") int studentCode,
                             @Query("teacher_id") long teacherId
    );
}
