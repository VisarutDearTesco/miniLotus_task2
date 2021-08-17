package com.visarut.minilotus_task2

import android.app.Application
import com.visarut.minilotus_task2.data.di.NameModule
import com.visarut.minilotus_task2.data.di.appModule
import com.visarut.minilotus_task2.data.di.retrofitModule
import com.visarut.minilotus_task2.domain.di.useCaseModule
import com.visarut.minilotus_task2.domain.epoxy.modules.viewmodelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(appModule,viewmodelModule,retrofitModule,useCaseModule,NameModule))
        }
    }
}