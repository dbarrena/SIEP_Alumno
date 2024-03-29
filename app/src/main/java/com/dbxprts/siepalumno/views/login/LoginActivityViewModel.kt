package com.dbxprts.siepalumno.views.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dbxprts.siepalumno.api.LoginService
import com.dbxprts.siepalumno.model.Family
import com.dbxprts.siepalumno.views.base.BaseViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LoginActivityViewModel @Inject
constructor(
    private val loginService: LoginService
) : BaseViewModel() {
    val family: MutableLiveData<Family> by lazy {
        MutableLiveData<Family>().apply { setValue(null) }
    }

    fun findUser(email: String) {
        loginService.findFamily(email)
            .enqueue(object : Callback<Family?> {
                override fun onResponse(call: Call<Family?>, response: Response<Family?>) {
                    if (response.code() == 200) {
                        response.body()?.let {
                            family.postValue(it)
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

                override fun onFailure(call: Call<Family?>, t: Throwable) {
                    messages.postValue("Error ${t.localizedMessage}")
                }

            })
    }
}