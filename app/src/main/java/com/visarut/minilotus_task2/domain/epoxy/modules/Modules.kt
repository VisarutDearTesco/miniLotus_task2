package com.visarut.minilotus_task2.domain.epoxy.modules

import com.visarut.minilotus_task2.data.repository.apiService.ApiService
import com.visarut.minilotus_task2.view.feature.featurePromotion.Page1fragmentViewModel
import com.visarut.minilotus_task2.view.feature.featureBanner.Page2ViewModel
import com.visarut.minilotus_task2.view.feature.featureHeader.Page3ViewModel
import com.visarut.minilotus_task2.data.repository.MiniLotusRepository
import com.visarut.minilotus_task2.domain.usecase.GetWidgetBrandUseCase
import com.visarut.minilotus_task2.view.feature.featureAddcount.TestViewBindingViewModel
import com.visarut.minilotus_task2.view.feature.featureDeliveryHome.DeliveryHomePageViewModel
import com.visarut.minilotus_task2.view.feature.featureHomeWithEpoxy.Page5ViewModel
import com.visarut.minilotus_task2.view.feature.featureSaveName.SaveNameViewModel
import com.visarut.minilotus_task2.view.feature.featureSingleBanner.SingleBannerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel


import org.koin.dsl.module

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
        Page5ViewModel(get(),get(),get())
    }

    viewModel {
        SaveNameViewModel(get(),get())
    }

    viewModel {
        SingleBannerViewModel()
    }

    viewModel {
        DeliveryHomePageViewModel(get())
    }
}

