package com.dbxprts.siepalumno.views.main.homework

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dbxprts.siepalumno.api.HomeworkService
import com.dbxprts.siepalumno.model.Homework
import com.dbxprts.siepalumno.views.base.BaseViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class HomeworkFragmentViewModel @Inject
constructor(
    private val homeworkService: HomeworkService
) : BaseViewModel() {
    val homework: MutableLiveData<ArrayList<Homework>> by lazy {
        MutableLiveData<ArrayList<Homework>>().apply { setValue(null) }
    }

    fun getHomework(studentID: Long) {
        homeworkService.getStudentHomework(studentID)
            .enqueue(object : Callback<ArrayList<Homework>> {
                override fun onResponse(
                    call: Call<ArrayList<Homework>>,
                    response: Response<ArrayList<Homework>>
                ) {
                    if (response.code() == 200) {
                        response.body()?.let {
                            homework.postValue(it)
                        } ?: run {
                            messages.postValue(
                                "No hay tareas por el momento."
                            )
                        }
                    } else {
                        messages.postValue("Error code ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<ArrayList<Homework>>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            })
    }
}