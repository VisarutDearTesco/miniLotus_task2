package com.visarut.minilotus_task2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.visarut.minilotus_task2.Repository.MiniLotusRepository
import com.visarut.minilotus_task2.model.DataItem
import com.visarut.minilotus_task2.recycleView.PromotionItemTypeText
import com.visarut.minilotus_task2.recycleView.RecycleViewBaseItem
import kotlinx.coroutines.launch

class Page1fragmentViewModel(val respository: MiniLotusRepository) : ViewModel() {

    val promotionList = MutableLiveData(ArrayList<RecycleViewBaseItem>())

    init {

        viewModelScope.launch {
            val res = respository.getBanner()
            res?.let { saveBanners(it) }

        }

    }

    private fun saveBanners(banners: List<DataItem?>) {

        val newArr = ArrayList<RecycleViewBaseItem>()

        for (item in banners) {
            item?.banners!!.forEach {
//                promotionList.add(PromotionItem(it?.image.toString(), it?.url.toString()))

                newArr.add(PromotionItemTypeText("test2"))
                newArr.add(PromotionItemTypeImage(it?.image.toString(), it?.url.toString()))
            }
        }


        promotionList.value = newArr

    }

}

