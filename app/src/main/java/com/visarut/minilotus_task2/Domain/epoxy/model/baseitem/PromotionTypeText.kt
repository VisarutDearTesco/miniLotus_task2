package com.visarut.minilotus_task2.Domain.epoxy.model.baseitem

import com.visarut.minilotus_task2.Domain.epoxy.RecycleViewBaseItem
import com.visarut.minilotus_task2.Domain.epoxy.model.baseitem.ListType.Companion.TYPE_TEXT_ONLY

data class PromotionTypeText(
    var title: String
) : RecycleViewBaseItem(TYPE_TEXT_ONLY)