package com.visarut.minilotus_task2.data.di

import com.visarut.minilotus_task2.data.repository.apiService.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {

    single {
        Retrofit.Builder()
            .baseUrl("https://api.qa.customer.it-lotus.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(ApiService::class.java)
    }

}