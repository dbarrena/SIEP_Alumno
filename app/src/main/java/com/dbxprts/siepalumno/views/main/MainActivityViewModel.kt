package com.dbxprts.siepalumno.views.main

import androidx.lifecycle.MutableLiveData
import com.dbxprts.siepalumno.api.StudentService
import com.dbxprts.siepalumno.model.Student
import com.dbxprts.siepalumno.views.base.BaseViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivityViewModel @Inject
constructor(
    private val studentService: StudentService
) : BaseViewModel() {
    val students: MutableLiveData<ArrayList<Student?>> by lazy {
        MutableLiveData<ArrayList<Student?>>().apply { setValue(null) }
    }

    fun getStudentsFromStudent(familyID: Long) {
        studentService.findStudentsByFamily(familyID)
            .enqueue(object : Callback<ArrayList<Student?>> {
                override fun onResponse(
                    call: Call<ArrayList<Student?>>,
                    response: Response<ArrayList<Student?>>
                ) {
                    if (response.code() == 200) {
                        response.body()?.let {
                            students.postValue(it)
                        } ?: run {
                            messages.postValue(
                                "Usuario no encontrado en la base de datos, " +
                                        "por favor informar de esto al correo"
                            )
                        }
                    } else {
                        messages.postValue("Error code ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<ArrayList<Student?>>, t: Throwable) {
                    messages.postValue("Error ${t.localizedMessage}")
                }

            })
    }
}