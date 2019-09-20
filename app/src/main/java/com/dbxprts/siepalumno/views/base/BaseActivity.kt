package com.dbxprts.siepalumno.views.base

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dbxprts.siepalumno.extension.vm
import javax.inject.Inject
import kotlin.reflect.KClass

@SuppressLint("Registered")
open class BaseActivity<T: ViewModel>(model: KClass<T>): AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    val viewModel by lazy { vm(viewModelFactory, model) }
}