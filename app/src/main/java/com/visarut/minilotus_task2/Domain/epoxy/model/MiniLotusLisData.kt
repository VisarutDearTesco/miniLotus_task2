package com.visarut.minilotus_task2.Domain.epoxy.model

import androidx.lifecycle.MutableLiveData
import com.visarut.minilotus_task2.Domain.epoxy.BannersItem

data class MiniLotusLisData(
    var widgetList: MutableLiveData<ArrayList<FeatureBrandsItem>>,
    var bannerList: MutableLiveData<ArrayList<BannersItem>>,
    var promotionList: MutableLiveData<ArrayList<BannersItem>>,
)
