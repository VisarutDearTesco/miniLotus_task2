package com.visarut.minilotus_task2.view.recycleView

import android.app.Application
import com.visarut.minilotus_task2.Domain.epoxy.modules.appModule
import com.visarut.minilotus_task2.Domain.epoxy.modules.retrofitModule
import com.visarut.minilotus_task2.Domain.epoxy.modules.viewmodelModule
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