package com.visarut.minilotus_task2.Domain.epoxy.model.baseitem

import com.visarut.minilotus_task2.Domain.epoxy.RecycleViewBaseItem
import com.visarut.minilotus_task2.Domain.epoxy.model.baseitem.ListType.Companion.TYPE_IMAGE

data class PromotionTypeImage(
    var imageUrl: String
) : RecycleViewBaseItem(TYPE_IMAGE)