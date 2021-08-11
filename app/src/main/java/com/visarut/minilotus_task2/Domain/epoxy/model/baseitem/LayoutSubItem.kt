package com.visarut.minilotus_task2.Domain.epoxy.model.baseitem

import com.visarut.minilotus_task2.Domain.epoxy.model.baseitem.ListType.Companion.TYPE_LISTLOGO
import com.visarut.minilotus_task2.Domain.epoxy.RecycleViewBaseItem

data class LayoutSubItem(
    var logoData : ArrayList<RecycleViewBaseItem>
) : RecycleViewBaseItem(TYPE_LISTLOGO)
