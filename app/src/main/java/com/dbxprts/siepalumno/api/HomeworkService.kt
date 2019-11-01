package com.dbxprts.siepalumno.api

import com.dbxprts.siepalumno.model.Homework
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeworkService {
    @GET("homework/find_by_student/{student_id}")
    fun getStudentHomework(@Path("student_id") studentID: Long): Call<ArrayList<Homework>>
}