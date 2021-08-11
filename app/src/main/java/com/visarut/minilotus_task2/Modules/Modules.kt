package com.visarut.minilotus_task2.Modules

import com.visarut.minilotus_task2.ApiService.ApiService
import com.visarut.minilotus_task2.featurePromotion.Page1fragmentViewModel
import com.visarut.minilotus_task2.featureBanner.Page2ViewModel
import com.visarut.minilotus_task2.featureHeader.Page3ViewModel
import com.visarut.minilotus_task2.Repository.MiniLotusRepository
import com.visarut.minilotus_task2.featureAddcount.TestViewBindingViewModel
import com.visarut.minilotus_task2.page5.Page5ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel


import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    // single - Defines a singleton of class
    // factory - defines a factory( creates new instance every time )
    single {
        MiniLotusRepository(get())
    }
}

val viewmodelModule = module {
    viewModel {
        Page1fragmentViewModel(get())
    }

    viewModel {
        Page2ViewModel(get())
    }

    viewModel {
        Page3ViewModel()
    }

    viewModel {
        TestViewBindingViewModel()
    }
    viewModel {
        Page5ViewModel(get())
    }
}

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