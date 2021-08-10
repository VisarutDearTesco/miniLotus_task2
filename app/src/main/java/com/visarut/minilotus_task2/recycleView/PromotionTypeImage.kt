package com.visarut.minilotus_task2.recycleView

import com.visarut.minilotus_task2.recycleView.ListType.Companion.TYPE_IMAGE

data class PromotionTypeImage(
    var imageUrl: String
) : RecycleViewBaseItem(TYPE_IMAGE)