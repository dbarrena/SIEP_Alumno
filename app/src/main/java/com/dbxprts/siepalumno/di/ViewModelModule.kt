package com.dbxprts.siepalumno.di

import androidx.lifecycle.ViewModelProvider
import com.dbxprts.siepalumno.factory.AppViewModelFactory
import dagger.Binds
import dagger.Module

@Suppress("unused")
@Module
internal abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory
}