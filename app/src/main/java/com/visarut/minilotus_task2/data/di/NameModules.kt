package com.visarut.minilotus_task2.data.di

import android.content.Context
import com.visarut.minilotus_task2.data.repository.MiniLotusRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val NameModule = module {
    // single - Defines a singleton of class
    // factory - defines a factory( creates new instance every time )


    single {
        androidContext().getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
    }
}