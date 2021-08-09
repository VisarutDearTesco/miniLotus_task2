package com.visarut.minilotus_task2

import com.visarut.minilotus_task2.recycleView.ListType.Companion.TYPE_IMAGE
import com.visarut.minilotus_task2.recycleView.RecycleViewBaseItem


data class PromotionItemTypeImage(
    var imageUrl: String,
    var title: String
) : RecycleViewBaseItem(TYPE_IMAGE)

