package com.visarut.minilotus_task2.domain.di

import com.visarut.minilotus_task2.data.repository.MiniLotusRepository
import com.visarut.minilotus_task2.domain.usecase.*
import org.koin.dsl.module


val useCaseModule = module {
    // single - Defines a singleton of class
    // factory - defines a factory( creates new instance every time )
    single {
        GetWidgetBrandUseCase(get())
    }

    single {
        GetPromoBannerUseCase(get())
    }

    single {
        GetBannerUseCase(get())
    }

    single {
        GetSavedNameUseCase(get())
    }

    single {
        PostSavedNameUseCase(get())
    }


}
