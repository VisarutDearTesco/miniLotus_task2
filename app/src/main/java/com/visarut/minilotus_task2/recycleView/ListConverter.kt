package com.visarut.minilotus_task2.recycleView

import com.visarut.minilotus_task2.PromotionItemTypeImage

class ListConverter {

    companion object {

        fun AddText(title: String): PromotionItemTypeText {
            return PromotionItemTypeText(title)
        }

        fun AddImage(title: String, imageUrl: String): PromotionItemTypeImage {
            return PromotionItemTypeImage(imageUrl, title)
        }
    }
}