package com.mustafa.androidcleanarch

import android.app.Application
import com.mustafa.androidcleanarch.di.homeViewModelModule
import com.mustafa.di.sampleModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()


        startKoin {
            if (BuildConfig.DEBUG) {
                androidLogger()
            }
            androidContext(this@App)
            modules(sampleModule, homeViewModelModule)
        }
    }

}