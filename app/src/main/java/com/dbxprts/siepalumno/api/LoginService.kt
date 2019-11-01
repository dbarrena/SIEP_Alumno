package com.dbxprts.siepalumno.api

import com.dbxprts.siepalumno.model.Family
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LoginService {
    @GET("family/find_by_email/{email}")
    fun findFamily(@Path("email") email: String): Call<Family?>
}