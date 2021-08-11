package com.visarut.minilotus_task2.view.recycleView.feature.featureHeader

import androidx.lifecycle.ViewModel
import com.visarut.minilotus_task2.Domain.epoxy.RecycleViewBaseItem

class Page3ViewModel : ViewModel() {
    val promotionList = ArrayList<RecycleViewBaseItem>()

    init{
//        promotionList.add(PromotionItem3("EXAMPLE1"))
//        promotionList.add(PromotionItem3("EXAMPLE2"))
//        promotionList.add(PromotionItem3("EXAMPLE3"))
//        promotionList.add(PromotionItem3("EXAMPLE4"))
//        promotionList.add(PromotionItem3("EXAMPLE5"))
//        promotionList.add(PromotionItem3("EXAMPLE6"))
    }

    fun getData(): ArrayList<RecycleViewBaseItem> {
        return promotionList
    }
}