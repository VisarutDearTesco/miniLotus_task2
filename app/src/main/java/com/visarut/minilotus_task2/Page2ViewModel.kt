package com.visarut.minilotus_task2

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.visarut.minilotus_task2.ApiService.ApiService
import com.visarut.minilotus_task2.Repository.MiniLotusRepository
import com.visarut.minilotus_task2.model.BannerResponse
import com.visarut.minilotus_task2.model.DataItem
import kotlinx.coroutines.launch

class Page2ViewModel(val miniLotusRepository: MiniLotusRepository) : ViewModel() {
    val promotionList = MutableLiveData(ArrayList<PromotionItem2>())
//    var miniLotusRepository : MiniLotusRepository = MiniLotusRepository()

    init{
        viewModelScope.launch {
            val res = miniLotusRepository.getPromoBanner()
            res?.let { saveBanners(it) }
        }
    }

    private fun saveBanners(banners: List<DataItem?>){

        val newArr = ArrayList<PromotionItem2>()

        for (item in banners) {
            item?.banners!!.forEach {
//                promotionList.add(PromotionItem(it?.image.toString(), it?.url.toString()))
                newArr.add(PromotionItem2(it?.image.toString()))
            }
        }
        promotionList.value = newArr

    }

}