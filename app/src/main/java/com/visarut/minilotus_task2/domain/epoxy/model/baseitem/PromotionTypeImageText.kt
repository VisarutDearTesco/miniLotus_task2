package com.visarut.minilotus_task2.domain.epoxy.model.baseitem

import com.visarut.minilotus_task2.domain.epoxy.RecycleViewBaseItem
import com.visarut.minilotus_task2.domain.epoxy.model.baseitem.ListType.Companion.TYPE_IMAGE_TEXT

data class PromotionTypeImageText(
    var imageUrl: String,
    var title: String
) : RecycleViewBaseItem(TYPE_IMAGE_TEXT)