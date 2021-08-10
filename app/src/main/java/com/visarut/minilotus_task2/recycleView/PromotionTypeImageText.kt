package com.visarut.minilotus_task2.recycleView

import com.visarut.minilotus_task2.recycleView.ListType.Companion.TYPE_IMAGE_TEXT

data class PromotionTypeImageText(
    var imageUrl: String,
    var title: String
) : RecycleViewBaseItem(TYPE_IMAGE_TEXT)