package com.dbxprts.siepalumno.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dbxprts.siepalumno.factory.AppViewModelFactory
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
    internal abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory
}