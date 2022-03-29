package com.nek12.catfacts

import android.app.Application
import com.nek12.catfacts.di.appModule
import logcat.AndroidLogcatLogger
import logcat.LogPriority
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

class CatFactsApplication : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        AndroidLogcatLogger.installOnDebuggableApp(this, minPriority = LogPriority.VERBOSE)

        startKoin {
            androidContext(applicationContext)
            modules(appModule)
        }
    }
}
