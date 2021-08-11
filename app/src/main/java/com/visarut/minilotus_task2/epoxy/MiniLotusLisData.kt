package com.visarut.minilotus_task2.epoxy

import androidx.lifecycle.MutableLiveData
import com.visarut.minilotus_task2.model.FeatureBrandsItem
import com.visarut.minilotus_task2.recycleView.BannersItem
import com.visarut.minilotus_task2.recycleView.RecycleViewBaseItem

data class MiniLotusLisData(
    var widgetList: MutableLiveData<ArrayList<FeatureBrandsItem>>,
    var bannerList: MutableLiveData<ArrayList<BannersItem>>,
    var promotionList: MutableLiveData<ArrayList<BannersItem>>,
)
