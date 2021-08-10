package com.visarut.minilotus_task2.recycleView

import com.visarut.minilotus_task2.recycleView.ListType.Companion.TYPE_TEXT_ONLY

data class PromotionTypeText(
    var title: String
) : RecycleViewBaseItem(TYPE_TEXT_ONLY)