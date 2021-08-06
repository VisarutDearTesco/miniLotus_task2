package com.visarut.minilotus_task2

import android.app.Application
import com.visarut.minilotus_task2.Modules.appModule
import com.visarut.minilotus_task2.Modules.retrofitModule
import com.visarut.minilotus_task2.Modules.viewmodelModule
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(appModule,viewmodelModule,retrofitModule))
        }
    }
}