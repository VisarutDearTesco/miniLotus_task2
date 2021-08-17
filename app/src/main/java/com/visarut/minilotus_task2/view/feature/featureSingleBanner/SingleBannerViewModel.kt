package com.visarut.minilotus_task2.view.feature.featureSingleBanner

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.navArgs
class SingleBannerViewModel : ViewModel() {
    var imageUrl = MutableLiveData<String?>()

    fun setImageUrl(url : String?) {
        imageUrl.value = url
    }

}