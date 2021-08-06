package com.visarut.minilotus_task2

import kotlin.collections.ArrayList


data class PromotionItem(
    var imageUrl: String,
    var title: String
)

data class PromotionItem2(
    var imageUrl: String
)

data class PromotionItem3(
    var title: String
)

data class BannerData(
    var template : String,
    var displayDuration : Int,
    var banner : ArrayList<PromotionItem>
)

data class Status(
    var code : Int,
    var message : String
)

data class ResBanner(
    var status : Status,
    var data : ArrayList<BannerData>
)
