package com.dbxprts.siepalumno.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dbxprts.siepalumno.factory.AppViewModelFactory
import com.dbxprts.siepalumno.views.login.LoginActivityViewModel
import com.dbxprts.siepalumno.views.main.MainActivityViewModel
import com.dbxprts.siepalumno.views.main.home.HomeFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
internal abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeFragmentViewModel::class)
    internal abstract fun bindHomeFragmentViewModel(viewModel: HomeFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginActivityViewModel::class)
    internal abstract fun bindLoginActivityViewModel(viewModel: LoginActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    internal abstract fun bindMainActivityViewModel(viewModel: MainActivityViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory
}