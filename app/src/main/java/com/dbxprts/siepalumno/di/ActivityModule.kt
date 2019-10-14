package com.dbxprts.siepalumno.di

import com.dbxprts.siepalumno.views.login.LoginActivity
import com.dbxprts.siepalumno.views.login.LoginActivityViewModel
import com.dbxprts.siepalumno.views.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(
        modules = [
            MainFragmentModule::class
        ]
    )
    internal abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun contributeLoginActivity(): LoginActivity
}