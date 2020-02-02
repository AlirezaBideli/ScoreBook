package com.aira.scorebook.network;

import com.aira.scorebook.model.Student;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class StudentController implements Callback<Student> {

    public void start(Student student) {
        Retrofit retrofit = RetrofitInstance.getInstance();
        StudentAPI postApi = retrofit.create(StudentAPI.class);
        String firstName = student.getName();
        String lastName = student.getLastName();
        int studentCode = student.getStudentCode();
        long teacherId = student.getTeacherId();


        Call<Student> call = postApi.addStudent(firstName, lastName, studentCode, teacherId);
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<Student> call, Response<Student> response) {

        if (response.isSuccessful()) {

        }
    }

    @Override
    public void onFailure(Call<Student> call, Throwable t) {

        t.printStackTrace();
    }
}
