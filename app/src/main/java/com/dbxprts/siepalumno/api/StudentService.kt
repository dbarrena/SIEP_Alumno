package com.dbxprts.siepalumno.api

import com.dbxprts.siepalumno.model.Family
import com.dbxprts.siepalumno.model.Student
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StudentService {
    @GET("student/find_by_family/{family_id}")
    fun findStudentsByFamily(@Path("family_id") familyID: Long): Call<ArrayList<Student?>>
}