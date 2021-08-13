package com.visarut.minilotus_task2.domain.epoxy.model

import androidx.lifecycle.MutableLiveData
import com.visarut.minilotus_task2.domain.epoxy.BannersItem

data class MiniLotusListData(
    var widgetList: MutableLiveData<ArrayList<FeatureBrandsItem>>?,
    var bannerList: MutableLiveData<ArrayList<BannersItem>>?,
    var promotionList: MutableLiveData<ArrayList<BannersItem>>?
)
