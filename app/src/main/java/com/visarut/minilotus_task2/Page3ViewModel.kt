package com.visarut.minilotus_task2

import androidx.lifecycle.ViewModel

class Page3ViewModel : ViewModel() {
    val promotionList = ArrayList<PromotionItem3>()

    init{
        promotionList.add(PromotionItem3("EXAMPLE1"))
        promotionList.add(PromotionItem3("EXAMPLE2"))
        promotionList.add(PromotionItem3("EXAMPLE3"))
        promotionList.add(PromotionItem3("EXAMPLE4"))
        promotionList.add(PromotionItem3("EXAMPLE5"))
        promotionList.add(PromotionItem3("EXAMPLE6"))
    }

    fun getData(): ArrayList<PromotionItem3> {
        return promotionList
    }
}