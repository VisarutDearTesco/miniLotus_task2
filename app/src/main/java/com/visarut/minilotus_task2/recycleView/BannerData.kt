package com.visarut.minilotus_task2

data class BannerData(
    var template : String,
    var displayDuration : Int,
    var banner : ArrayList<PromotionItemTypeImage>
)