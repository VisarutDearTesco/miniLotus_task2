package com.visarut.minilotus_task2.domain.epoxy.model

import com.visarut.minilotus_task2.domain.epoxy.model.baseitem.PromotionTypeImage

data class BannerData(
    var template : String,
    var displayDuration : Int,
    var banner : ArrayList<PromotionTypeImage>
)