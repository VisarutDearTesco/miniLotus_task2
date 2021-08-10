package com.visarut.minilotus_task2.recycleView

import com.visarut.minilotus_task2.recycleView.ListType.Companion.TYPE_LISTLOGO

data class LayoutSubItem(
    var logoData : ArrayList<RecycleViewBaseItem>
) : RecycleViewBaseItem(TYPE_LISTLOGO)
