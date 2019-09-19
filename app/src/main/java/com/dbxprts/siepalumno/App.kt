package com.dbxprts.siepalumno

import android.content.ContextWrapper
import com.dbxprts.siepalumno.di.DaggerAppComponent
import com.pixplicity.easyprefs.library.Prefs
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber

class App: DaggerApplication() {
    private val appComponent = DaggerAppComponent.builder()
        .application(this)
        .build()

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)


        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        initializeEasyPrefs()
    }

    private fun initializeEasyPrefs() {
        Prefs.Builder()
            .setContext(this)
            .setMode(ContextWrapper.MODE_PRIVATE)
            .setPrefsName(packageName)
            .setUseDefaultSharedPreference(true)
            .build()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return appComponent
    }
}