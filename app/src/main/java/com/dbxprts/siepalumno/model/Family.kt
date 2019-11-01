package com.dbxprts.siepalumno.model

data class Family(
    var familyID: Long? = null,

    var schoolID: Long? = null,

    var userSIEP: String? = null,

    var password: String? = null,

    var fatherName: String? = null,

    var fatherFirstLastName: String? = null,

    var fatherSecondLastName: String? = null,

    var fatherAddress: String? = null,

    var fatherPhone: String? = null,

    var fatherCellphone: String? = null,

    var fatherWorkName: String? = null,

    var fatherWorkAddress: String? = null,

    var fatherWorkPhone: String? = null,

    var motherName: String? = null,

    var motherFirstLastName: String? = null,

    var motherSecondLastName: String? = null,

    var motherAddress: String? = null,

    var motherPhone: String? = null,

    var motherCellphone: String? = null,

    var motherWorkName: String? = null,

    var motherWorkAddress: String? = null,

    var motherWorkPhone: String? = null,

    var email: String? = null
)
