package com.visarut.minilotus_task2.recycleView

import com.visarut.minilotus_task2.recycleView.ListType.Companion.TYPE_LOGO

data class LogoBanner(
    var imageUrl: String
) : RecycleViewBaseItem(TYPE_LOGO)
