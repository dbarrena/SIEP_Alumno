package com.dbxprts.siepalumno.model

import java.util.*

data class Homework (
    val homeworkID: Long,
    val teacher: Teacher,
    val schoolSubject: SchoolSubject,
    val homeworkDate: Date,
    val deliverDate: Date,
    val homework: String
)