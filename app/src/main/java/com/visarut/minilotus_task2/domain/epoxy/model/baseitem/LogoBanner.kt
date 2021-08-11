package com.visarut.minilotus_task2.domain.epoxy.model.baseitem

import com.visarut.minilotus_task2.domain.epoxy.RecycleViewBaseItem
import com.visarut.minilotus_task2.domain.epoxy.model.baseitem.ListType.Companion.TYPE_LOGO

data class LogoBanner(
    var imageUrl: String
) : RecycleViewBaseItem(TYPE_LOGO)
