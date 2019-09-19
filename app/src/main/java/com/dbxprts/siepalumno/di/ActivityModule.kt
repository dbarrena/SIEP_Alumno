package com.dbxprts.siepalumno.di

import com.dbxprts.siepalumno.views.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    internal abstract fun contributeMainACtivity(): MainActivity
}