package com.dbxprts.siepalumno.model

data class Teacher (
    val employeeID: Long,
    val name: String,
    val firstLastName: String,
    val secondLastName: String,
    val address: String,
    val phone: Long,
    val cellphone: Long
)
