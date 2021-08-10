package com.visarut.minilotus_task2.recycleView

data class BannerData(
    var template : String,
    var displayDuration : Int,
    var banner : ArrayList<PromotionTypeImage>
)