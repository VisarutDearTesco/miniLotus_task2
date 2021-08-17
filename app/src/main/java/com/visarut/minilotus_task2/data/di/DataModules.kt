package com.visarut.minilotus_task2.data.di

import com.visarut.minilotus_task2.data.repository.MiniLotusRepository
import com.visarut.minilotus_task2.data.repository.SharedPrefRepository
import com.visarut.minilotus_task2.data.repository.apiService.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    // single - Defines a singleton of class
    // factory - defines a factory( creates new instance every time )
    single {
        MiniLotusRepository(get())
    }

    single{
        SharedPrefRepository(get())
    }
}


