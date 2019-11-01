package com.dbxprts.siepalumno.model

import com.google.gson.annotations.SerializedName

data class SchoolSubject (
    @SerializedName("schoolSubjectName")
    val name: String
)
