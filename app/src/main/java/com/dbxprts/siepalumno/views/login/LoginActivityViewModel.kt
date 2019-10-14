package com.dbxprts.siepalumno.views.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dbxprts.siepalumno.views.base.BaseViewModel
import javax.inject.Inject

class LoginActivityViewModel @Inject
constructor(

): BaseViewModel(){
    val userAuthenticated: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>().apply { setValue(null) }
    }
}